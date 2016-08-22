package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public interface ImageDetailContract {
    interface View extends BaseView<Presenter> {
        void showImage(String imageUrl);
    }

    interface Presenter extends BasePresenter {
        void getImageUrl();
    }
}
