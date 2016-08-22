package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurBaseItem;
import com.fjodors.imgurmvp.models.ImgurImage;

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
                imageUrl = "http://i.imgur.com/" + imgurImage.getId() + ".gif";
            } else {
                imageUrl = imgurImage.getLink();
            }
            imageDetailView.showImage(imageUrl);

        }
    }

}
