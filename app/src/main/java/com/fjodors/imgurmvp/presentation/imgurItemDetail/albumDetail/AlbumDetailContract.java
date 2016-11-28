package com.fjodors.imgurmvp.presentation.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.data.remote.model.ImageResponse;
import com.fjodors.imgurmvp.presentation.base.MvpPresenter;
import com.fjodors.imgurmvp.presentation.base.MvpView;

/**
 * Created by Fjodors on 18.08.2016.
 */
interface AlbumDetailContract {
    interface View extends MvpView {
        void showAlbumsImages(ImageResponse imageResponse);

        void showError(Throwable e);

        void showError(int e);

        void hideProgress();

        void showProgress();
    }

    interface Presenter extends MvpPresenter<AlbumDetailContract.View> {
        void fetchAlbumsImages(String albumId);
    }
}
