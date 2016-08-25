package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.ImgurManager;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailPresenter implements AlbumDetailContract.Presenter {
    private AlbumDetailContract.View albumDetailView;
    private ImgurManager imgurManager;

    public AlbumDetailPresenter(AlbumDetailContract.View albumDetailView, ImgurManager imgurManager) {
        this.albumDetailView = albumDetailView;
        this.imgurManager = imgurManager;
    }

    @Override
    public void fetchAlbumsImages(String albumId) {
        imgurManager.getAlbumImages(albumId)
                .doOnTerminate(() -> albumDetailView.hideProgress())
                .subscribe(imageResponse -> {
                    if (imageResponse != null && !imageResponse.data.isEmpty()) {
                        albumDetailView.showAlbumsImages(imageResponse);
                    } else {
                        albumDetailView.showError(new Throwable(((AlbumDetailFragment) albumDetailView).getString(R.string.error_message_no_data)));
                    }
                }, e -> albumDetailView.showError(e));

    }
}
