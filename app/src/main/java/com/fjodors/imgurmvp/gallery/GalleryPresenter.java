package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.ImgurManager;

import javax.inject.Inject;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryPresenter implements GalleryContract.Presenter {
    private GalleryContract.View galleryView;
    private ImgurManager imgurManager;

    @Inject
    public GalleryPresenter(ImgurManager imgurManager, GalleryContract.View galleryView) {
        this.galleryView = galleryView;
        this.imgurManager = imgurManager;
    }

    @Override
    public void fetchGallery() {
        imgurManager.getMainGallery()
                .doOnTerminate(() -> galleryView.hideProgress())
                .subscribe(galleryResponse -> {
                    if (galleryResponse != null && !galleryResponse.data.isEmpty()) {
                        galleryView.showGallery(galleryResponse);
                    } else {
                        galleryView.showError(new Throwable(((GalleryFragment) galleryView).getString(R.string.error_message_no_data)));
                    }
                }, e -> galleryView.showError(e));
    }
}
