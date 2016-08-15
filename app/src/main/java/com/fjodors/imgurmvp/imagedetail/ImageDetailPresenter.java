package com.fjodors.imgurmvp.imagedetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.images.ImagesFragment;
import com.fjodors.imgurmvp.images.ImgurGalleryModel;

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
        ImgurGalleryModel.Data image = (ImgurGalleryModel.Data) fragment.getArguments().getSerializable(ImagesFragment.IMAGE);
        String imageUrl = "";
        if (image != null) {
            if (image.isInGallery() && image.getCover() != null) {


                //TODO: make request for gallery items from album
                imageUrl = "http://i.imgur.com/" + image.getCover() + HUGE_IMAGE_THUMBNAIL + ".jpg";

            } else {
                imageUrl = image.getLink();
            }
        }
        imageDetailView.showImage(imageUrl);
    }

    @Override
    public void start() {

    }
}
