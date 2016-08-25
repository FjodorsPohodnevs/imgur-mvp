package com.fjodors.imgurmvp;

import com.fjodors.imgurmvp.api.ImgurApiModule;
import com.fjodors.imgurmvp.gallery.GallerySubComponent;
import com.fjodors.imgurmvp.gallery.GalleryModule;
import com.fjodors.imgurmvp.imgurItemDetail.albumDetail.AlbumDetailSubComponent;
import com.fjodors.imgurmvp.imgurItemDetail.albumDetail.AlbumDetailModule;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailSubComponent;
import com.fjodors.imgurmvp.imgurItemDetail.imageDetail.ImageDetailModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Singleton
@Component(modules = {ImgurAppModule.class, ImgurApiModule.class})
public interface ImgurAppComponent {

    GallerySubComponent newGallerySubComponent(GalleryModule module);

    AlbumDetailSubComponent newAlbumDetailSubComponent(AlbumDetailModule module);

    ImageDetailSubComponent newImageDetailSubComponent(ImageDetailModule module);

}
