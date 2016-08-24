package com.fjodors.imgurmvp.gallery;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by fjodors.pohodnevs on 8/24/2016.
 */
@Module
public class GalleryModule {
    @Provides
    GalleryContract.Presenter provideGalleryPresenter(Retrofit retrofit) {
        return new GalleryPresenter(retrofit);
    }
}
