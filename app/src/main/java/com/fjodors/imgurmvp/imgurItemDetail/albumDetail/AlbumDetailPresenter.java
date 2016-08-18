package com.fjodors.imgurmvp.imgurItemDetail.albumDetail;

import android.support.v4.app.Fragment;

import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;
import com.fjodors.imgurmvp.api.responses.ImageResponse;
import com.fjodors.imgurmvp.gallery.GalleryFragment;
import com.fjodors.imgurmvp.models.ImgurAlbum;
import com.fjodors.imgurmvp.models.ImgurBaseItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
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
    public void fetchAlbumsImages(Fragment fragment) {
        ImgurBaseItem imgurBaseItem = (ImgurBaseItem) fragment.getArguments().getSerializable(GalleryFragment.IMAGE);
        ImgurAlbum imgurAlbum = (ImgurAlbum) imgurBaseItem;

        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        apiService.getAlbumImages(imgurAlbum.getId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ImageResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        albumDetailView.showError();
                        albumDetailView.hideProgress();
                    }

                    @Override
                    public void onNext(ImageResponse imageResponse) {
                        if (imageResponse != null && !imageResponse.data.isEmpty()) {
//                    List<ImgurImage> imgurImages = response.body().data;
//
//                    String imageUrl = "";
//
//                    if (imgurImages.get(0).getType().equalsIgnoreCase("image/gif")) {
//                        imageUrl = "http://i.imgur.com/" + imgurImages.get(0).getId() + ".gif";
//                    } else {
//                        imageUrl = imgurImages.get(0).getLink();
//                    }
                            albumDetailView.showImage(imageResponse);
                        } else {
                            albumDetailView.showError();
                        }
                        albumDetailView.hideProgress();
                    }
                });
    }

    @Override
    public void start() {

    }
}
