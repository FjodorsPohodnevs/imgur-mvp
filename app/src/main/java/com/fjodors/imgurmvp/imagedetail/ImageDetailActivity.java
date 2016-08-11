package com.fjodors.imgurmvp.imagedetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.images.ImageModel;
import com.fjodors.imgurmvp.images.ImagesFragment;
import com.fjodors.imgurmvp.util.ActivityUtils;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        ImageModel.Data image = (ImageModel.Data) getIntent().getSerializableExtra(ImagesFragment.IMAGE);

        ImageDetailFragment imageDetailFragment = ImageDetailFragment.newInstace();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ImagesFragment.IMAGE, image);
        imageDetailFragment.setArguments(bundle);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), imageDetailFragment, R.id.contentFrame);
    }
}
