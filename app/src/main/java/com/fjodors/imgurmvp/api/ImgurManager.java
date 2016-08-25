package com.fjodors.imgurmvp.api;

import com.fjodors.imgurmvp.api.responses.GalleryResponse;
import com.fjodors.imgurmvp.api.responses.ImageResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fjodors.pohodnevs on 8/25/2016.
 */
public class ImgurManager {

    private static final String MAIN_GALLERY_DEFAULT_SECTION = "hot";
    private static final String MAIN_GALLERY_DEFAULT_SORT = "viral";
    private static final String MAIN_GALLERY_DEFAULT_PAGE = "1";

    private ImgurApiService imgurApiService;

    public ImgurManager(ImgurApiService imgurApiService) {
        this.imgurApiService = imgurApiService;
    }

    //TODO: implement more functional operators for data processing

    public Observable<GalleryResponse> getMainGallery() {
        return imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION, MAIN_GALLERY_DEFAULT_SORT, MAIN_GALLERY_DEFAULT_PAGE, true)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ImageResponse> getAlbumImages(String albumId) {
        return imgurApiService.getAlbumImages(albumId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
