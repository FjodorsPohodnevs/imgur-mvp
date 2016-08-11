package com.fjodors.imgurmvp.images;

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
        ImagesApiInterface apiService =
                ImagesClient.getClient().create(ImagesApiInterface.class);

        Call<ImageModel> call = apiService.getRandomGallery();
        call.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {
                imagesView.showGallery(response.body());
                imagesView.hideProgress();
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                imagesView.showError();
                imagesView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
