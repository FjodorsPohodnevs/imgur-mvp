package com.fjodors.imgurmvp.presentation.albumDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.data.AlbumRepository;
import com.fjodors.imgurmvp.data.remote.ErrorManager;
import com.fjodors.imgurmvp.data.remote.model.ImageResponse;
import com.fjodors.imgurmvp.model.ImgurAlbum;
import com.fjodors.imgurmvp.presentation.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumDetailActivity extends BaseActivity implements AlbumDetailContract.View {

    public static final String IMAGE = "IMAGE";

    AlbumDetailContract.Presenter albumDetailPresenter;
    private AlbumDetailRecyclerAdapter albumDetailRecyclerAdapter;

    @BindView(R.id.album_image_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    AlbumRepository albumRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        ImgurApp.get(this)
                .getImgurAppComponent()
                .inject(this);

        albumDetailPresenter = new AlbumDetailPresenter(albumRepository);
        albumDetailPresenter.attachView(this);

        initRecyclerView();

        ImgurAlbum imgurAlbum = (ImgurAlbum) getIntent().getSerializableExtra(IMAGE);
        if (imgurAlbum != null) {
            albumDetailPresenter.fetchAlbumsImages(imgurAlbum.getId());
        }
    }

    @Override
    public void showAlbumsImages(ImageResponse imageResponse) {
        albumDetailRecyclerAdapter.setImgurBaseItemModel(imageResponse.getData());
        albumDetailRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        albumDetailRecyclerAdapter = new AlbumDetailRecyclerAdapter();
        recyclerView.setAdapter(albumDetailRecyclerAdapter);
    }

    @Override
    public void showError(Throwable e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(int e) {
        int errorMessage = ErrorManager.getErrorMessage(e);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
