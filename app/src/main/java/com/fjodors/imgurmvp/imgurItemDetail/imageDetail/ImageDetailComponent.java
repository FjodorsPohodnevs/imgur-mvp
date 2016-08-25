package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@FragmentScope
@Subcomponent(modules = ImageDetailModule.class)
public interface ImageDetailComponent {
    void inject(ImageDetailFragment imageDetailFragment);
}
