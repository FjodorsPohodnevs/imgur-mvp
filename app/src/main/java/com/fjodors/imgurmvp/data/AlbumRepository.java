package com.fjodors.imgurmvp.data;

import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.data.remote.model.ImageResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AlbumRepository {

    private ImgurApiService imgurApiService;

    public AlbumRepository(ImgurApiService imgurApiService) {
        this.imgurApiService = imgurApiService;
    }

    public Observable<ImageResponse> getAlbumImages(String albumId) {
        return imgurApiService.getAlbumImages(albumId);
    }
}
