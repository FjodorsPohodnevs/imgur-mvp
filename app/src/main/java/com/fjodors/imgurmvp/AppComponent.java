package com.fjodors.imgurmvp;

import com.fjodors.imgurmvp.api.ImgurApiModule;
import com.fjodors.imgurmvp.gallery.GalleryComponent;
import com.fjodors.imgurmvp.gallery.GalleryModule;
import com.fjodors.imgurmvp.imgurItemDetail.albumDetail.AlbumDetailComponent;
import com.fjodors.imgurmvp.imgurItemDetail.albumDetail.AlbumDetailModule;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailComponent;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Singleton
@Component(modules = {AppModule.class, ImgurApiModule.class})
public interface AppComponent {

    GalleryComponent plus(GalleryModule module);

    AlbumDetailComponent plus(AlbumDetailModule module);

    ImageDetailComponent plus(ImageDetailModule module);
}
