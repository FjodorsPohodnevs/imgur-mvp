package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Module
public class ImageDetailModule {
    private ImageDetailContract.View imageDetailFragment;

    public ImageDetailModule(ImageDetailContract.View imageDetailFragment) {
        this.imageDetailFragment = imageDetailFragment;
    }

    @Provides
    @FragmentScope
    ImageDetailContract.View provideImageDetailFragment() {
        return imageDetailFragment;
    }

    @Provides
    @FragmentScope
    ImageDetailContract.Presenter provideImageDetailPresenter() {
        return new ImageDetailPresenter(imageDetailFragment);
    }
}
