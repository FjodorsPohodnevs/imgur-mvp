package com.fjodors.imgurmvp.api.dependencyInjection;

import com.fjodors.imgurmvp.gallery.GalleryFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by fjodors.pohodnevs on 8/22/2016.
 */
@Singleton
@Component(modules = {AppModule.class, ImgurNetworkModule.class})
public interface NetworkComponent {
    void inject(GalleryFragment galleryFragment);
}