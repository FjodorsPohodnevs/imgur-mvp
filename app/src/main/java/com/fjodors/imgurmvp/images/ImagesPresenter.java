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

        Call<ImgurGalleryModel> call = apiService.getTopic("Rio_2016", "top", "1");
        call.enqueue(new Callback<ImgurGalleryModel>() {
            @Override
            public void onResponse(Call<ImgurGalleryModel> call, Response<ImgurGalleryModel> response) {
                imagesView.showGallery(response.body());
                imagesView.hideProgress();
            }

            @Override
            public void onFailure(Call<ImgurGalleryModel> call, Throwable t) {
                imagesView.showError();
                imagesView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
