package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.api.responses.GalleryResponse;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface GalleryContract {
    interface View {
        void showGallery(GalleryResponse galleryResponse);

        void showError(Throwable e);

        void hideProgress();
    }

    interface Presenter {
        void fetchGallery();
    }
}
