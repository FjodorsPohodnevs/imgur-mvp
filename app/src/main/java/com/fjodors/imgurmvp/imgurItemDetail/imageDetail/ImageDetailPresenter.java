package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.responses.ImageResponse;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurAlbum;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.models.ImgurImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailPresenter implements ImageDetailContract.Presenter {

    private ImageDetailContract.View imageDetailView;

    private static final String HUGE_IMAGE_THUMBNAIL = "h";

    public ImageDetailPresenter(ImageDetailContract.View imageDetailView) {
        this.imageDetailView = imageDetailView;
        imageDetailView.setPresenter(this);
    }

    @Override
    public void getImageUrl(Fragment fragment) {
        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) fragment.getArguments().getSerializable(GalleryFragment.IMAGE);
        String imageUrl = "";
        if (imgurBaseItem != null) {
            if (imgurBaseItem instanceof ImgurAlbum) {
                ImgurAlbum imgurAlbum = (ImgurAlbum) imgurBaseItem;
                fetchAlbumsImages(imgurAlbum.getId());
            } else if (imgurBaseItem instanceof ImgurImage) {
                ImgurImage imgurImage = (ImgurImage) imgurBaseItem;
                //TODO: need to change format to gifv/mp4(Glide is not supporting)
                if (imgurImage.getType().equalsIgnoreCase("image/gif")) {
                    imageUrl = "http://i.imgur.com/" + imgurImage.getId() + ".gif";
                } else {
                    imageUrl = imgurImage.getLink();
                }
                imageDetailView.showImage(imageUrl);
            }
        }

    }

    @Override
    public void fetchAlbumsImages(String albumId) {
        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        //TODO: change to observable
        Call<ImageResponse> call = apiService.getAlbumImages(albumId);

        //TODO: Implement rxJava here
        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                if (response != null && response.body() != null && !response.body().data.isEmpty()) {
                    List<ImgurImage> imgurImages = response.body().data;

                    String imageUrl = "";

                    if (imgurImages.get(0).getType().equalsIgnoreCase("image/gif")) {
                        imageUrl = "http://i.imgur.com/" + imgurImages.get(0).getId() + ".gif";
                    } else {
                        imageUrl = imgurImages.get(0).getLink();
                    }
                    imageDetailView.showImage(imageUrl);
                } else {
                    imageDetailView.showError();
                }
                imageDetailView.hideProgress();
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                imageDetailView.showError();
                imageDetailView.hideProgress();
            }
        });
    }

    @Override
    public void start() {

    }
}
