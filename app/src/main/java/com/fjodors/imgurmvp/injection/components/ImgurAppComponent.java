package com.fjodors.imgurmvp.injection.components;

import com.fjodors.imgurmvp.injection.modules.ImgurApiModule;
import com.fjodors.imgurmvp.injection.modules.ImgurAppModule;
import com.fjodors.imgurmvp.presentation.gallery.GalleryActivity;
import com.fjodors.imgurmvp.presentation.albumDetail.AlbumDetailActivity;
import com.fjodors.imgurmvp.presentation.imageDetail.ImageDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Singleton
@Component(modules = {ImgurAppModule.class, ImgurApiModule.class})
public interface ImgurAppComponent {

    void inject(GalleryActivity galleryActivity);

    void inject(AlbumDetailActivity albumDetailActivity);

    void inject(ImageDetailActivity imageDetailActivity);
}
