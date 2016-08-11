package com.fjodors.imgurmvp.images;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImagesContract {

    interface View extends BaseView<Presenter> {
        void showGallery(ImageModel imageModel);

        void showError();
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void callImgur();
    }
}
