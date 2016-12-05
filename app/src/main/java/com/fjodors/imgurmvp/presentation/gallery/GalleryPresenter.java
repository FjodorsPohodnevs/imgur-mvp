package com.fjodors.imgurmvp.presentation.gallery;

import com.fjodors.imgurmvp.data.GalleryRepository;
import com.fjodors.imgurmvp.presentation.base.BasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryPresenter extends BasePresenter<GalleryContract.View> implements GalleryContract.Presenter {
    private GalleryRepository galleryRepository;

    @Inject
    public GalleryPresenter(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public void fetchGallery() {
        checkViewAttached();
        getView().showProgress();
        addSubscription(galleryRepository.getMainGallery()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ImgurBaseItemList -> {
                    getView().hideProgress();
                    if (!ImgurBaseItemList.isEmpty()) {
                        getView().showGallery(ImgurBaseItemList);
                    } else {
                        getView().showError(0);
                    }
                }, e -> {
                    getView().hideProgress();
                    getView().showError(e);
                }));
    }

//    @Override
//    public void fetchGallery() {
//        checkViewAttached();
//        getView().showProgress();
//        addSubscription(galleryRepository.getMainGallery()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(galleryResponse -> {
//                    getView().hideProgress();
//                    if (galleryResponse != null && !galleryResponse.data.isEmpty()) {
//                        getView().showGallery(galleryResponse);
//                    } else {
//                        getView().showError(galleryResponse != null ? galleryResponse.status : 0);
//                    }
//                }, e -> {
//                    getView().hideProgress();
//                    getView().showError(e);
//                }));
//    }
}
