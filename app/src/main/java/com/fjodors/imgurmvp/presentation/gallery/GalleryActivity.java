package com.fjodors.imgurmvp.presentation.gallery;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.data.GalleryRepository;
import com.fjodors.imgurmvp.data.remote.ErrorManager;
import com.fjodors.imgurmvp.model.ImgurAlbum;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.model.ImgurImage;
import com.fjodors.imgurmvp.presentation.albumDetail.AlbumDetailActivity;
import com.fjodors.imgurmvp.presentation.base.BaseActivity;
import com.fjodors.imgurmvp.presentation.imageDetail.ImageDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends BaseActivity implements GalleryContract.View, GalleryRecyclerAdapter.ItemClickListener {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImgurApp.get(this)
                .getImgurAppComponent()
                .inject(this);

        galleryPresenter = new GalleryPresenter(galleryRepository);
        galleryPresenter.attachView(this);

        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(() -> galleryPresenter.fetchGallery());
        initRecyclerView();

        galleryPresenter.fetchGallery();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        galleryRecyclerAdapter = new GalleryRecyclerAdapter(this);
        recyclerView.setAdapter(galleryRecyclerAdapter);
    }

    @Override
    public void showGallery(List<ImgurBaseItem> imgurBaseItemList) {
        galleryRecyclerAdapter.setImgurBaseItemModel(imgurBaseItemList);
        galleryRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(int e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
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
        launchGalleryItemDetailPage(imgurBaseItem);
    }

    private void launchGalleryItemDetailPage(ImgurBaseItem imgurBaseItem) {
        Intent intent;
        if (imgurBaseItem instanceof ImgurAlbum) {
            ImgurAlbum imgurAlbum = (ImgurAlbum) imgurBaseItem;
            intent = new Intent(this, AlbumDetailActivity.class);
            intent.putExtra(IMAGE, imgurAlbum);
        } else {
            ImgurImage imgurImage = (ImgurImage) imgurBaseItem;
            intent = new Intent(this, ImageDetailActivity.class);
            intent.putExtra(IMAGE, imgurImage);
        }
        startActivity(intent);
    }
}


