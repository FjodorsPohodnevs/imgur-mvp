package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public interface ImageDetailContract {

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
