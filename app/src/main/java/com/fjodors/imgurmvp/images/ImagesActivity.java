package com.fjodors.imgurmvp.images;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.util.ActivityUtils;

public class ImagesActivity extends AppCompatActivity {

    ImagesPresenter imagesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        //TODO: set toolbar
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);

        //TODO: set navigation drawer
        //....

        ImagesContract.View imgurListFragment = ImagesFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), (Fragment) imgurListFragment, R.id.contentFrame);

        //TODO: maybe inject presenter(FOR TESTING PURPOSES)
        imagesPresenter = new ImagesPresenter(imgurListFragment);

        //TODO: loading previously saved instances
    }
}
