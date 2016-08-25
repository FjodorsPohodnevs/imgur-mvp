package com.fjodors.imgurmvp.gallery;

import android.support.v7.widget.LinearLayoutManager;

import com.fjodors.imgurmvp.FragmentScope;
import com.fjodors.imgurmvp.api.ImgurManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/24/2016.
 */
@Module
public class GalleryModule {


    private GalleryContract.View galleryFragment;
    private GalleryActivity galleryActivity;

    public GalleryModule(GalleryContract.View galleryFragment, GalleryActivity galleryActivity) {
        this.galleryFragment = galleryFragment;
        this.galleryActivity = galleryActivity;
    }

    @Provides
    @FragmentScope
    GalleryContract.View provideGalleryFragment() {
        return galleryFragment;
    }

    @Provides
    @FragmentScope
    GalleryActivity galleryActivity() {
        return galleryActivity;
    }

    @Provides
    @FragmentScope
    GalleryContract.Presenter provideGalleryPresenter(ImgurManager imgurManager) {
        return new GalleryPresenter(imgurManager, galleryFragment);
    }

    @Provides
    @FragmentScope
    GalleryRecyclerAdapter provideGalleryRecyclerAdapter() {
        return new GalleryRecyclerAdapter((GalleryRecyclerAdapter.ItemClickListener) galleryFragment);
    }

    @Provides
    @FragmentScope
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(galleryActivity);
    }
}
