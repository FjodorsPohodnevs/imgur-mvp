package com.fjodors.imgurmvp.images;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.util.ActivityUtils;

public class ImagesActivity extends AppCompatActivity {

    ImagesPresenter imagesPresenter;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //TODO: set navigation drawer
        //....

        ImagesContract.View imgurListFragment = ImagesFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), (Fragment) imgurListFragment, R.id.contentFrame);

        //TODO: maybe inject Presenter(FOR TESTING PURPOSES)
        imagesPresenter = new ImagesPresenter(imgurListFragment);

        //TODO: loading previously saved instances
    }
}
