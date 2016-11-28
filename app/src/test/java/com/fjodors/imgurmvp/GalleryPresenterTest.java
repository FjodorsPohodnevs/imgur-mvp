package com.fjodors.imgurmvp;

import com.fjodors.imgurmvp.data.GalleryRepository;
import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.presentation.gallery.GalleryContract;
import com.fjodors.imgurmvp.presentation.gallery.GalleryPresenter;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GalleryPresenterTest {

    private static final String MAIN_GALLERY_DEFAULT_SECTION = "hot";
    private static final String MAIN_GALLERY_DEFAULT_SORT = "viral";
    private static final String MAIN_GALLERY_DEFAULT_PAGE = "1";

    @Mock
    GalleryRepository galleryRepository;

    @Mock
    GalleryContract.View galleryView;

    private GalleryContract.Presenter galleryPresenter;

    @Before
    public void setUp() {
        this.galleryPresenter = new GalleryPresenter(galleryRepository);//TODO: which is better imgur api manager or api
    }

    /**
     * 1.Handle empty list
     *
     * 2.Handle Error message: 200; 400; 401; 403; 404; 429; 500
     * //https://api.imgur.com/errorhandling
     *
     * 3.Handle "No internet connection"
     *
     *
     * 4.HANDLE good response: list with items
     */

    /**
     * DO NOT USE REAL BE, MOCK IT(Mock response from BE)
     */


//    @Test
//    public void noInternetConnectionTest() {
//        // given
//        when(imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
//                MAIN_GALLERY_DEFAULT_SORT,
//                MAIN_GALLERY_DEFAULT_PAGE,
//                true)).thenReturn(new Throwable("400"));
//        // when
//        galleryPresenter.fetchGallery();
//        // then
//        verify(galleryView.showError());
//        //verify or assert
//    }
//
//    @Test
//    public void errorStatusCodeTest() {
//        // given
//        when(imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
//                MAIN_GALLERY_DEFAULT_SORT,
//                MAIN_GALLERY_DEFAULT_PAGE,
//                true)).thenReturn(new Throwable("400"));
//        // when
//        galleryPresenter.fetchGallery();
//        // then
//        verify(galleryView.showError());
//        //verify or assert
//    }
//
//    @Test
//    public void emptyGalleryListTest() {
//        // given
//        when(imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
//                MAIN_GALLERY_DEFAULT_SORT,
//                MAIN_GALLERY_DEFAULT_PAGE,
//                true)).thenReturn(Observable.just(Collections.emptyList()));
//        // when
//        galleryPresenter.fetchGallery();
//        // then
//        verify();
//        //verify or assert
//    }
//
//    @Test
//    public void filledGalleryItemListTest() {
//        // given
//        when(imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
//                MAIN_GALLERY_DEFAULT_SORT,
//                MAIN_GALLERY_DEFAULT_PAGE,
//                true)).thenReturn(new Throwable("400"));
//        // when
//        galleryPresenter.fetchGallery();
//        // then
//        verify(galleryView.showError());
//        //verify or assert
//    }
}
