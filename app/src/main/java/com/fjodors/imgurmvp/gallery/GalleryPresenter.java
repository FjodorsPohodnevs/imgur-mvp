package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.responses.GalleryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        //TODO: change to observable
        Call<GalleryResponse> call = apiService.getMainGallery("hot", "viral", "1");

        //TODO: Implement rxJava here
        call.enqueue(new Callback<GalleryResponse>() {
            @Override
            public void onResponse(Call<GalleryResponse> call, Response<GalleryResponse> response) {
                if (response != null && response.body() != null && !response.body().data.isEmpty()) {
                    galleryView.showGallery(response.body());
                } else {
                    galleryView.showError();
                }
                galleryView.hideProgress();
            }

            @Override
            public void onFailure(Call<GalleryResponse> call, Throwable t) {
                galleryView.showError();
                galleryView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
