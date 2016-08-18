package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.responses.ImageResponse;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurAlbum;
import com.fjodors.imgurmvp.models.ImgurBaseItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailPresenter implements AlbumDetailContract.Presenter {

    private AlbumDetailContract.View albumDetailView;

    public AlbumDetailPresenter(AlbumDetailContract.View albumDetailView) {
        this.albumDetailView = albumDetailView;
        albumDetailView.setPresenter(this);
    }


    @Override
    public void fetchAlbumsImages(Fragment fragment) {
        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) fragment.getArguments().getSerializable(GalleryFragment.IMAGE);
        ImgurAlbum imgurAlbum = (ImgurAlbum) imgurBaseItem;

        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        //TODO: change to observable
        Call<ImageResponse> call = apiService.getAlbumImages(imgurAlbum.getId());

        //TODO: Implement rxJava here
        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response != null && response.body() != null && !response.body().data.isEmpty()) {
//                    List<ImgurImage> imgurImages = response.body().data;
//
//                    String imageUrl = "";
//
//                    if (imgurImages.get(0).getType().equalsIgnoreCase("image/gif")) {
//                        imageUrl = "http://i.imgur.com/" + imgurImages.get(0).getId() + ".gif";
//                    } else {
//                        imageUrl = imgurImages.get(0).getLink();
//                    }
                    albumDetailView.showImage(response.body());
                } else {
                    albumDetailView.showError();
                }
                albumDetailView.hideProgress();
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                albumDetailView.showError();
                albumDetailView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
