package com.fjodors.imgurmvp.presentation.imgurItemDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.presentation.gallery.GalleryFragment;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.albumDetail.AlbumDetailFragment;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.imageDetail.ImageDetailFragment;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.imageDetail.ImageDetailPresenter;
import com.fjodors.imgurmvp.util.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImgurItemDetailActivity extends AppCompatActivity {
    protected ImageDetailPresenter imageDetailPresenter;

    @BindView(R.id.toolbar)
    Toolbar myToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        // Load fragment
        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) getIntent().getSerializableExtra(GalleryFragment.IMAGE);
        if (imgurBaseItem.isAlbum()) {
            AlbumDetailFragment albumDetailFragment = AlbumDetailFragment.newInstance(imgurBaseItem);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), albumDetailFragment, R.id.contentFrame);
        } else {
            ImageDetailFragment imageDetailFragment = ImageDetailFragment.newInstace(imgurBaseItem);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), imageDetailFragment, R.id.contentFrame);
        }
    }
}
