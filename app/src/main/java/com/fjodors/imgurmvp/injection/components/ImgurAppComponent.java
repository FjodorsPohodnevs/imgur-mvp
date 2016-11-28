package com.fjodors.imgurmvp.injection.components;

import com.fjodors.imgurmvp.injection.modules.ImgurApiModule;
import com.fjodors.imgurmvp.injection.modules.ImgurAppModule;
import com.fjodors.imgurmvp.presentation.gallery.GalleryFragment;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.albumDetail.AlbumDetailFragment;
import com.fjodors.imgurmvp.presentation.imgurItemDetail.imageDetail.ImageDetailFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Singleton
@Component(modules = {ImgurAppModule.class, ImgurApiModule.class})
public interface ImgurAppComponent {

    void inject(GalleryFragment galleryFragment);

    void inject(AlbumDetailFragment albumDetailFragment);

    void inject(ImageDetailFragment imageDetailFragment);
}
