package com.fjodors.imgurmvp.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.models.ImgurBaseItem;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public interface ImageDetailContract {
    interface View {
        void showImage(String imageUrl);
    }

    interface Presenter {
        void getImageUrl(ImgurBaseItem imgurBaseItem);
    }
}
