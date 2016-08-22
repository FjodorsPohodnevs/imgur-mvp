package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.BasePresenter;
import com.fjodors.imgurmvp.BaseView;
import com.fjodors.imgurmvp.api.responses.ImageResponse;

/**
 * Created by Fjodors on 18.08.2016.
 */
public interface AlbumDetailContract {
    interface View extends BaseView<Presenter> {
        void showImage(ImageResponse imageResponse);

        void showError();

        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void fetchAlbumsImages();
    }
}
