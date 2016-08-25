package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@FragmentScope
@Subcomponent(modules = AlbumDetailModule.class)
public interface AlbumDetailComponent {
    void inject(AlbumDetailFragment albumDetailFragment);
}
