package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.models.ImgurImage;

import javax.inject.Inject;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailPresenter implements ImageDetailContract.Presenter {
    private static final String IMAGE_FORMAT_GIF = ".gif";
    private static final String IMGUR_URL = "http://i.imgur.com/";

    private ImageDetailContract.View imageDetailView;

    @Inject
    public ImageDetailPresenter(ImageDetailContract.View imageDetailView) {
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
