package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;

/**
 * Created by Fjodors on 18.08.2016.
 */
public interface AlbumDetailContract {

    interface View extends BaseView<Presenter> {
        void showImage(String imageUrl);
        void showError();
        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void getImageUrl(Fragment fragment);
        void fetchAlbumsImages(String albumId);
    }
}
