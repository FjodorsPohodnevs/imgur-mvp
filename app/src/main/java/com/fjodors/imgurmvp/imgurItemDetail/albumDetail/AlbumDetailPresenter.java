package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurAlbum;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fjodors on 18.08.2016.
 */
public class AlbumDetailPresenter implements AlbumDetailContract.Presenter {
    private AlbumDetailContract.View albumDetailView;

    public AlbumDetailPresenter(AlbumDetailContract.View albumDetailView) {
        this.albumDetailView = albumDetailView;
        albumDetailView.setPresenter(this);
    }

    @Override
    public void fetchAlbumsImages() {
        ImgurAlbum imgurAlbum = (ImgurAlbum) ((AlbumDetailFragment) albumDetailView).getArguments().getSerializable(GalleryFragment.IMAGE);

        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        if (imgurAlbum != null) {
            apiService.getAlbumImages(imgurAlbum.getId())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(imageResponse -> {
                        if (imageResponse != null && !imageResponse.data.isEmpty()) {
                            albumDetailView.showImage(imageResponse);
                        } else {
                            albumDetailView.showError();
                        }
                    }, e -> {
                        albumDetailView.showError();
                        albumDetailView.hideProgress();
                    }, () -> albumDetailView.hideProgress());
        }
    }

    @Override
    public void start() {
        fetchAlbumsImages();
    }
}
