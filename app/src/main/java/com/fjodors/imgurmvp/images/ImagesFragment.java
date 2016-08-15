package com.fjodors.imgurmvp.images;

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

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.imagedetail.ImageDetailActivity;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImagesFragment extends Fragment implements ImagesContract.View {

    private static final String TAG = ImagesFragment.class.getSimpleName();

    public static final String IMAGE = "IMAGE";

    private RecyclerView recyclerView;
    private ImagesRecyclerAdapter imagesRecyclerAdapter;
    private SwipeRefreshLayout refreshLayout;
    private ImagesContract.Presenter imgurPresenter;
    private ProgressBar progressBar;

    public static ImagesFragment newInstance() {
        ImagesFragment imagesFragment = new ImagesFragment();
        return imagesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_images, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_layout);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                imgurPresenter.callImgur();
            }
        });

        initRecyclerView(view);

        imgurPresenter.callImgur();

        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.imgur_recycler_view);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        ImagesRecyclerAdapter.ItemClickListener itemClickListener = new ImagesRecyclerAdapter.ItemClickListener() {
            @Override
            public void onItemClick(ImgurGalleryModel.Data image) {
                Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
                intent.putExtra(IMAGE, image);
                startActivity(intent);
            }
        };

        imagesRecyclerAdapter = new ImagesRecyclerAdapter(itemClickListener);
        recyclerView.setAdapter(imagesRecyclerAdapter);
    }

    @Override
    public void setPresenter(ImagesContract.Presenter presenter) {
        imgurPresenter = presenter;
    }

    @Override
    public void showGallery(ImgurGalleryModel imgurGalleryModel) {
        imagesRecyclerAdapter.clear();
        imagesRecyclerAdapter.setImgurGalleryModel(imgurGalleryModel);
        imagesRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
