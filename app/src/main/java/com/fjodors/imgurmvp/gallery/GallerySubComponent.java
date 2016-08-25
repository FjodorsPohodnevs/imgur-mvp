package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by Fjodors on 24.08.2016.
 */
@FragmentScope
@Subcomponent(modules = GalleryModule.class)
public interface GallerySubComponent {
    void inject(GalleryFragment galleryFragment);
}

