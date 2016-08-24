package com.fjodors.imgurmvp.gallery;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/24/2016.
 */
@Module
public class GalleryModule {
    private GalleryActivity galleryActivity;

    public GalleryModule(GalleryActivity galleryActivity){
        this.galleryActivity = galleryActivity;
    }

    @Provides
    GalleryActivity galleryActivity(){
        return GalleryActivity;
    }

    @Provides
    GalleryPresenter provideGalleryPresenter(){
        return new GalleryPresenter(galleryActivity(), )
    }

}
