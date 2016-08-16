package com.fjodors.imgurmvp.imagedetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.images.ImagesFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItemModel;

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
        ImgurBaseItemModel imgurBaseItemModel = (ImgurBaseItemModel) fragment.getArguments().getSerializable(ImagesFragment.IMAGE);
        String imageUrl = "";
        if (imgurBaseItemModel != null) {
            //TODO: uncomment and fix
//            if (imgurBaseItemModel.isAlbum() && imgurBaseItemModel.getCover() != null) {
//                //TODO: make request for gallery items from album
//                imageUrl = "http://i.imgur.com/" + imgurBaseItemModel.getCover() + HUGE_IMAGE_THUMBNAIL + ".jpg";
//
//            } else {
//                imageUrl = imgurBaseItemModel.getLink();
//            }
            imageUrl = imgurBaseItemModel.getLink();
        }
        imageDetailView.showImage(imageUrl);
    }

    @Override
    public void start() {

    }
}
