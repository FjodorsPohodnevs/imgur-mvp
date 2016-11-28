package com.fjodors.imgurmvp.data;

import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GalleryRepository {

    private static final String MAIN_GALLERY_DEFAULT_SECTION = "hot";
    private static final String MAIN_GALLERY_DEFAULT_SORT = "viral";
    private static final String MAIN_GALLERY_DEFAULT_PAGE = "1";

    private ImgurApiService imgurApiService;

    public GalleryRepository(ImgurApiService imgurApiService) {
        this.imgurApiService = imgurApiService;
    }

    public Observable<GalleryResponse> getMainGallery() {
        return imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION, MAIN_GALLERY_DEFAULT_SORT, MAIN_GALLERY_DEFAULT_PAGE, true)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
