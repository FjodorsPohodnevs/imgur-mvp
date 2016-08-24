package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.ActivityScope;
import com.fjodors.imgurmvp.api.ImgurNetworkModule;
import com.fjodors.imgurmvp.api.NetworkComponent;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Fjodors on 24.08.2016.
 */
@Component(modules = {GalleryModule.class, ImgurNetworkModule.class})
//@Component(modules = GalleryModule.class, dependencies = NetworkComponent.class)
@ActivityScope
public interface GalleryComponent {
    Retrofit getRetrofit();

    void inject(GalleryFragment galleryFragment);
}

