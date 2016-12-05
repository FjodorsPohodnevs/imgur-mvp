package com.fjodors.imgurmvp.data;

import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.model.ImgurBaseItem;

import java.util.List;

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

    public Observable<List<ImgurBaseItem>> getMainGallery() {
        return Observable.defer(() -> imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
                MAIN_GALLERY_DEFAULT_SORT,
                MAIN_GALLERY_DEFAULT_PAGE,
                true).concatMap(imgurBaseItemList -> Observable.from(imgurBaseItemList.getData()))
                .toList());
    }

    public Observable<List<ImgurBaseItem>> getMainGallery2() {
        return imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
                MAIN_GALLERY_DEFAULT_SORT,
                MAIN_GALLERY_DEFAULT_PAGE,
                true)
                .map(GalleryResponse::getData);
    }

    public Observable<List<ImgurBaseItem>> getMainGallery3() {
        return imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
                MAIN_GALLERY_DEFAULT_SORT,
                MAIN_GALLERY_DEFAULT_PAGE,
                true)
                .map(GalleryResponse::getData);
    }

//    Observable.just(someQueryArgs)
//            .subscribeOn(Schedulers.io())
//            .map(param -> webApi.doWebQuery(param))
//            .map(response -> saveResponseToDB(response))
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(result -> updateUI(result));
}
