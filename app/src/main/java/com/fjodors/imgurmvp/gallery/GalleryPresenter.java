package com.fjodors.imgurmvp.gallery;

import android.support.annotation.MainThread;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.responses.GalleryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryPresenter implements GalleryContract.Presenter {

    private GalleryContract.View galleryView;

    public GalleryPresenter(GalleryContract.View galleryView) {
        this.galleryView = galleryView;
        galleryView.setPresenter(this);
    }

    @Override
    public void fetchGallery() {
        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        apiService.getMainGallery("hot", "viral", "1")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GalleryResponse>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        galleryView.showError();
                        galleryView.hideProgress();
                    }

                    @Override
                    public void onNext(GalleryResponse galleryResponse) {
                        if (galleryResponse != null && !galleryResponse.data.isEmpty()) {
                            galleryView.showGallery(galleryResponse);
                        } else {
                            galleryView.showError();
                        }
                        galleryView.hideProgress();
                    }
                });
    }

    @Override
    public void start() {

    }
}
