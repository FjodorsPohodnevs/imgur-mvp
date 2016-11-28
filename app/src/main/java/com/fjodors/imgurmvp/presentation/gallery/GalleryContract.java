package com.fjodors.imgurmvp.presentation.gallery;

import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.presentation.base.MvpPresenter;
import com.fjodors.imgurmvp.presentation.base.MvpView;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface GalleryContract {
    interface View extends MvpView {
        void showGallery(GalleryResponse galleryResponse);

        void showError(Throwable e);

        void showError(int e);

        void hideProgress();

        void showProgress();
    }

    interface Presenter extends MvpPresenter<View> {
        void fetchGallery();
    }
}
