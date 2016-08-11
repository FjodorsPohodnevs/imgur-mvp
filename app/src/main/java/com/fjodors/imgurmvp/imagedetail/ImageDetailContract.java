package com.fjodors.imgurmvp.imagedetail;

/**
 * Created by fjodors.pohodnevs on 8/11/2016.
 */
public interface ImageDetailContract {

    interface view {
        void showImage();
    }

    interface presenter {
        void vote();
    }
}
