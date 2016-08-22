package com.fjodors.imgurmvp.gallery;

import com.fjodors.imgurmvp.R;
import com.fjodors.imgurmvp.api.ImgurApiClient;
import com.fjodors.imgurmvp.api.ImgurApiService;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class GalleryPresenter implements GalleryContract.Presenter {
    private static final String MAIN_GALLERY_DEFAULT_SECTION = "hot";
    private static final String MAIN_GALLERY_DEFAULT_SORT = "viral";
    private static final String MAIN_GALLERY_DEFAULT_PAGE = "1";

    private GalleryContract.View galleryView;

    public GalleryPresenter(GalleryContract.View galleryView) {
        this.galleryView = galleryView;
        galleryView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchGallery();
    }

    @Override
    public void fetchGallery() {
        ImgurApiService apiService =
                ImgurApiClient.getClient().create(ImgurApiService.class);

        apiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION, MAIN_GALLERY_DEFAULT_SORT, MAIN_GALLERY_DEFAULT_PAGE, true)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> galleryView.hideProgress())
                .subscribe(galleryResponse -> {
                    if (galleryResponse != null && !galleryResponse.data.isEmpty()) {
                        galleryView.showGallery(galleryResponse);
                    } else {
                        galleryView.showError(new Throwable(((GalleryFragment) galleryView).getString(R.string.error_no_data)));
                    }
                }, e -> galleryView.showError(e));
    }
}
