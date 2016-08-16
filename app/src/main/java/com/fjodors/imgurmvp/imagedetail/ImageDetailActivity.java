package com.fjodors.imgurmvp.imagedetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.models.ImgurBaseItemModel;
import com.fjodors.imgurmvp.images.ImagesFragment;
import com.fjodors.imgurmvp.util.ActivityUtils;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailActivity extends AppCompatActivity {

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

        ImgurBaseItemModel imgurBaseItemModel = (ImgurBaseItemModel) getIntent().getSerializableExtra(ImagesFragment.IMAGE);

        ImageDetailFragment imageDetailFragment = ImageDetailFragment.newInstace();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ImagesFragment.IMAGE, imgurBaseItemModel);
        imageDetailFragment.setArguments(bundle);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), imageDetailFragment, R.id.contentFrame);

        imageDetailPresenter = new ImageDetailPresenter(imageDetailFragment);
    }
}
