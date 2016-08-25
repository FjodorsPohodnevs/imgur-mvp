package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.FragmentScope;
import com.fjodors.imgurmvp.api.ImgurManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
@Module
public class AlbumDetailModule {
    private AlbumDetailContract.View albumDetailFragment;

    public AlbumDetailModule(AlbumDetailContract.View albumDetailFragment) {
        this.albumDetailFragment = albumDetailFragment;
    }

    @Provides
    @FragmentScope
    AlbumDetailContract.View provideAlbumDetailFragment() {
        return albumDetailFragment;
    }


    @Provides
    @FragmentScope
    AlbumDetailContract.Presenter provideAlbumDetailPresenter(ImgurManager imgurManager) {
        return new AlbumDetailPresenter(albumDetailFragment, imgurManager);
    }
}
