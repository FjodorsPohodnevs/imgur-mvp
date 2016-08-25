package com.fjodors.imgurmvp.gallery;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.util.ActivityUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        //TODO: Implement search in toolbar for topic search functionality
        //TODO: set navigation drawer with account info(oAuth stuff)

        GalleryContract.View imgurListFragment = GalleryFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), (Fragment) imgurListFragment, R.id.contentFrame);
    }
}
