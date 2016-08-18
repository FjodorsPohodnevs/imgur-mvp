package com.fjodors.imgurmvp.gallery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.util.ActivityUtils;

public class GalleryActivity extends AppCompatActivity {

    GalleryPresenter galleryPresenter;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //TODO: set navigation drawer
        //....

        GalleryContract.View imgurListFragment = GalleryFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), (Fragment) imgurListFragment, R.id.contentFrame);

        //TODO: maybe inject Presenter(FOR TESTING PURPOSES)
        galleryPresenter = new GalleryPresenter(imgurListFragment);

        //TODO: loading previously saved instances
    }
}
