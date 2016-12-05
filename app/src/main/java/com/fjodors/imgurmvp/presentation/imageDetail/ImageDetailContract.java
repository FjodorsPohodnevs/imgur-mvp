package com.fjodors.imgurmvp.presentation.imageDetail;

import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.presentation.base.MvpPresenter;
import com.fjodors.imgurmvp.presentation.base.MvpView;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
interface ImageDetailContract {
    interface View extends MvpView {
        void showImage(String imageUrl);
    }

    interface Presenter extends MvpPresenter<ImageDetailContract.View> {
        void getImageUrl(ImgurBaseItem imgurBaseItem);
    }
}
