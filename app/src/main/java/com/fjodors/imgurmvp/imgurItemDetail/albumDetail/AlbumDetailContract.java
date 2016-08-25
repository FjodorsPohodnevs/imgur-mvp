package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.api.responses.ImageResponse;

/**
 * Created by Fjodors on 18.08.2016.
 */
public interface AlbumDetailContract {
    interface View {
        void showAlbumsImages(ImageResponse imageResponse);

        void showError(Throwable e);

        void hideProgress();
    }

    interface Presenter {
        void fetchAlbumsImages(String albumId);
    }
}
