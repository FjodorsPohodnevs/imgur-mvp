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

        Call<ImagesModel> call = apiService.getRandomGallery();
        call.enqueue(new Callback<ImagesModel>() {
            @Override
            public void onResponse(Call<ImagesModel> call, Response<ImagesModel> response) {
                imagesView.showGallery(response.body());
                imagesView.hideProgress();
            }

            @Override
            public void onFailure(Call<ImagesModel> call, Throwable t) {
                imagesView.showError();
                imagesView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
