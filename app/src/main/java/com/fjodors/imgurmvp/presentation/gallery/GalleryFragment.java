package com.fjodors.imgurmvp.presentation.gallery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.data.GalleryRepository;
import com.fjodors.imgurmvp.data.remote.ErrorManager;
import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.ImgurItemDetailActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryFragment extends Fragment implements GalleryContract.View, GalleryRecyclerAdapter.ItemClickListener {

    public static final String IMAGE = "IMAGE";

    @BindView(R.id.album_image_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private GalleryRecyclerAdapter galleryRecyclerAdapter;

    private GalleryContract.Presenter galleryPresenter;

    @Inject
    protected GalleryRepository galleryRepository;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImgurApp.get(getActivity())
                .getImgurAppComponent()
                .inject(this);

        galleryPresenter = new GalleryPresenter(galleryRepository);
        galleryPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);

        //TODO: implement infinity scroll with pagination

        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(() -> galleryPresenter.fetchGallery());
        initRecyclerView();

        galleryPresenter.fetchGallery();

        return view;
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        galleryRecyclerAdapter = new GalleryRecyclerAdapter(this);
        recyclerView.setAdapter(galleryRecyclerAdapter);
    }

    @Override
    public void showGallery(GalleryResponse galleryResponse) {
        galleryRecyclerAdapter.setImgurBaseItemModel(galleryResponse.getData());
        galleryRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(int e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(ImgurBaseItem imgurBaseItem) {
        Intent intent = new Intent(getActivity(), ImgurItemDetailActivity.class);
        intent.putExtra(IMAGE, imgurBaseItem);
        startActivity(intent);
    }
}
