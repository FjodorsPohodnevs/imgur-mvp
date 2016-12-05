package com.fjodors.imgurmvp.presentation.imageDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.fjodors.imgurmvp.ImgurApp;
import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.model.ImgurImage;
import com.fjodors.imgurmvp.presentation.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageDetailActivity extends BaseActivity implements ImageDetailContract.View {
    @BindView(R.id.image)
    ImageView imageView;

    protected ImageDetailPresenter imageDetailPresenter;

    public static final String IMAGE = "IMAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        ImgurApp.get(this)
                .getImgurAppComponent()
                .inject(this);

        imageDetailPresenter = new ImageDetailPresenter(this);
        imageDetailPresenter.attachView(this);

        ImgurImage imgurImage = (ImgurImage) getIntent().getSerializableExtra(IMAGE);
        imageDetailPresenter.getImageUrl(imgurImage);
    }

    @Override
    public void showImage(String imageUrl) {
        Picasso.with(this)
                .load(imageUrl)
                .error(R.drawable.ic_block_black_48dp)
                .fit()
                .centerInside()
                .into(imageView);
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showError(int e) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }
}
