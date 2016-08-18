package com.fjodors.imgurmvp.imgurItemDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.imgurItemDetail.albumDetail.AlbumDetailFragment;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailFragment;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailPresenter;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.util.ActivityUtils;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImgurItemDetailActivity extends AppCompatActivity {

    ImageDetailPresenter imageDetailPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) getIntent().getSerializableExtra(GalleryFragment.IMAGE);

        if (imgurBaseItem.isAlbum()) {
            AlbumDetailFragment albumDetailFragment = AlbumDetailFragment.newInstace();
            Bundle bundle = new Bundle();
            bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
            albumDetailFragment.setArguments(bundle);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), albumDetailFragment, R.id.contentFrame);
        } else {
            ImageDetailFragment imageDetailFragment = ImageDetailFragment.newInstace();
            Bundle bundle = new Bundle();
            bundle.putSerializable(GalleryFragment.IMAGE, imgurBaseItem);
            imageDetailFragment.setArguments(bundle);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), imageDetailFragment, R.id.contentFrame);
            imageDetailPresenter = new ImageDetailPresenter(imageDetailFragment);
        }
    }
}
