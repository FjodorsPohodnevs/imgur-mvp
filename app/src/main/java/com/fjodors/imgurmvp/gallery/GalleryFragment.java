package com.fjodors.imgurmvp.gallery;

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

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.responses.GalleryResponse;
import com.fjodors.imgurmvp.imgurItemDetail.ImgurItemDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryFragment extends Fragment implements GalleryContract.View {
    public static final String IMAGE = "IMAGE";

    @BindView(R.id.album_image_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private GalleryRecyclerAdapter galleryRecyclerAdapter;

    private GalleryContract.Presenter imgurPresenter;

    public static GalleryFragment newInstance() {
        GalleryFragment galleryFragment = new GalleryFragment();
        return galleryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        ButterKnife.bind(this, view);

        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(() -> imgurPresenter.fetchGallery());
        initRecyclerView();

        imgurPresenter.start();


        return view;
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        GalleryRecyclerAdapter.ItemClickListener itemClickListener = imgurBaseItemModel -> {
            Intent intent = new Intent(getActivity(), ImgurItemDetailActivity.class);
            intent.putExtra(IMAGE, imgurBaseItemModel);
            startActivity(intent);
        };

        galleryRecyclerAdapter = new GalleryRecyclerAdapter(itemClickListener);
        recyclerView.setAdapter(galleryRecyclerAdapter);
    }

    @Override
    public void setPresenter(GalleryContract.Presenter presenter) {
        imgurPresenter = presenter;
    }

    @Override
    public void showGallery(GalleryResponse galleryResponse) {
        galleryRecyclerAdapter.setImgurBaseItemModel(galleryResponse.getData());
        galleryRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
