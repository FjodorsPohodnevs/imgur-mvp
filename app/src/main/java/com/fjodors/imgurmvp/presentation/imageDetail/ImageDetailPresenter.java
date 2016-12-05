package com.fjodors.imgurmvp.presentation.imageDetail;

import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.model.ImgurImage;
import com.fjodors.imgurmvp.presentation.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailPresenter extends BasePresenter<ImageDetailContract.View> implements ImageDetailContract.Presenter {
    private static final String IMAGE_FORMAT_GIF = ".gif";
    private static final String IMGUR_URL = "http://i.imgur.com/";

    private ImageDetailContract.View imageDetailView;

    @Inject
    ImageDetailPresenter(ImageDetailContract.View imageDetailView) {
        this.imageDetailView = imageDetailView;
    }

    @Override
    public void getImageUrl(ImgurBaseItem imgurBaseItem) {
        String imageUrl;
        if (imgurBaseItem != null) {
            ImgurImage imgurImage = (ImgurImage) imgurBaseItem;
            //TODO: need to change format to gifv/mp4(Glide is not supporting)
            if (imgurImage.getType().equalsIgnoreCase("image/gif")) {
                imageUrl = IMGUR_URL + imgurImage.getId() + IMAGE_FORMAT_GIF;
            } else {
                imageUrl = imgurImage.getLink();
            }
            imageDetailView.showImage(imageUrl);

        }
    }

}
