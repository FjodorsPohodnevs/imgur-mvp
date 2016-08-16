package com.fjodors.imgurmvp.images;

import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.responses.BaseResponse;
import com.fjodors.imgurmvp.api.responses.GalleryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImagesPresenter implements ImagesContract.Presenter {

    private ImagesContract.View imagesView;

    public ImagesPresenter(ImagesContract.View imagesView) {
        this.imagesView = imagesView;
        imagesView.setPresenter(this);
    }

    @Override
    public void callImgur() {
        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        //TODO: change to observable
        Call<GalleryResponse> call = apiService.getTopic("Rio_2016", "top", "1");

        //TODO: Implement rxJava here
        call.enqueue(new Callback<GalleryResponse>() {
            @Override
            public void onResponse(Call<GalleryResponse> call, Response<GalleryResponse> response) {
                imagesView.showGallery(response.body());
                imagesView.hideProgress();
            }

            @Override
            public void onFailure(Call<GalleryResponse> call, Throwable t) {
                imagesView.showError();
                imagesView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
