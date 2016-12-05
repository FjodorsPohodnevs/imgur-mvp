package com.fjodors.imgurmvp.presentation.gallery;

import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.fjodors.imgurmvp.presentation.base.MvpPresenter;
import com.fjodors.imgurmvp.presentation.base.MvpView;

import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface GalleryContract {
    interface View extends MvpView {
        void showGallery(List<ImgurBaseItem> imgurBaseItemList);
    }

    interface Presenter extends MvpPresenter<View> {
        void fetchGallery();
    }
}
