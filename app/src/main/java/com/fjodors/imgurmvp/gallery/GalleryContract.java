package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;
import com.fjodors.imgurmvp.api.responses.GalleryResponse;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface GalleryContract {

    interface View extends BaseView<Presenter> {
        void showGallery(GalleryResponse galleryResponse);

        void showError();
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void fetchGallery();
    }
}
