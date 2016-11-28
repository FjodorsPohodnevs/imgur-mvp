package com.fjodors.imgurmvp.presentation.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.data.AlbumRepository;
import com.fjodors.imgurmvp.presentation.base.BasePresenter;

/**
 * Created by Fjodors on 18.08.2016.
 */
class AlbumDetailPresenter extends BasePresenter<AlbumDetailContract.View> implements AlbumDetailContract.Presenter {
    private AlbumRepository albumRepository;

    AlbumDetailPresenter(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void fetchAlbumsImages(String albumId) {
        checkViewAttached();
        getView().showProgress();
        albumRepository.getAlbumImages(albumId)
                .subscribe(imageResponse -> {
                    getView().hideProgress();
                    if (imageResponse != null && !imageResponse.data.isEmpty()) {
                        getView().showAlbumsImages(imageResponse);
                    } else {
                        getView().showError(imageResponse != null ? imageResponse.status : 0);
                    }
                }, e -> {
                    getView().hideProgress();
                    getView().showError(e);
                });
    }
}
