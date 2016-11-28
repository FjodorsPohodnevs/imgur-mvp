package com.fjodors.imgurmvp.presentation.imgurItemDetail.imageDetail;

import com.fjodors.imgurmvp.model.ImgurBaseItem;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
interface ImageDetailContract {
    interface View {
        void showImage(String imageUrl);
    }

    interface Presenter {
        void getImageUrl(ImgurBaseItem imgurBaseItem);
    }
}
