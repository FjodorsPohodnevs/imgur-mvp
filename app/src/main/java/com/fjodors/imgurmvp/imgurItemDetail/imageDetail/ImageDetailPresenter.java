package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.models.ImgurImage;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public class ImageDetailPresenter implements ImageDetailContract.Presenter {
    private static final String IMAGE_FORMAT_GIF = ".gif";
    private static final String IMGUR_URL = "http://i.imgur.com/";

    private ImageDetailContract.View imageDetailView;

    public ImageDetailPresenter(ImageDetailContract.View imageDetailView) {
        this.imageDetailView = imageDetailView;
        imageDetailView.setPresenter(this);
    }

    @Override
    public void start() {
        getImageUrl();
    }

    @Override
    public void getImageUrl() {
        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) ((ImageDetailFragment) imageDetailView).getArguments().getSerializable(GalleryFragment.IMAGE);
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
