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


    @Override
    public void start() {

    }
}
