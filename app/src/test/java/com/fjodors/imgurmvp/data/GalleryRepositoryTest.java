package com.fjodors.imgurmvp.data;

import com.fjodors.imgurmvp.data.remote.ImgurApiService;
import com.fjodors.imgurmvp.data.remote.model.AlbumResponse;
import com.fjodors.imgurmvp.data.remote.model.BaseResponse;
import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.data.remote.model.ImageResponse;
import com.fjodors.imgurmvp.model.ImgurBaseItem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GalleryRepositoryTest {

    private static final String MAIN_GALLERY_DEFAULT_SECTION = "hot";
    private static final String MAIN_GALLERY_DEFAULT_SORT = "viral";
    private static final String MAIN_GALLERY_DEFAULT_PAGE = "1";

    @Mock
    ImgurApiService imgurApiService;

    private GalleryRepository galleryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        galleryRepository = new GalleryRepository(imgurApiService);
    }

    //[Name of method under test]_[Conditions of test case]_[Expected Result]
//    @Test
//    public void getMainGallery_200OkResponse_InvokesCorrectApiCalls() {
//        //Given
//        when(imgurApiService.getMainGallery(MAIN_GALLERY_DEFAULT_SECTION,
//                MAIN_GALLERY_DEFAULT_SORT,
//                MAIN_GALLERY_DEFAULT_PAGE,
//                true)).thenReturn(Observable.just(galleryResponse()));
//
//        //When
//        TestSubscriber<GalleryResponse> subscriber = new TestSubscriber<>();
//        galleryRepository.getMainGallery().subscribe(subscriber);
//
//        //Then
//        subscriber.awaitTerminalEvent();
//        subscriber.assertNoErrors();
//
//        Assert.assertEquals();
//        verify();
//    }

    private GalleryResponse galleryResponse() {

        BaseResponse image = new ImageResponse();
        BaseResponse album = new AlbumResponse();

        List<ImgurBaseItem> imgurBaseItemList = new ArrayList<>();
//        imgurBaseItemList.add();
//        imgurBaseItemList.add();

        GalleryResponse galleryResponse = new GalleryResponse(imgurBaseItemList);
        return galleryResponse;
    }

//    private UsersList githubUserList() {
//        User user = new User();
//        user.setLogin(USER_LOGIN_RIGGAROO);
//
//        User user2 = new User();
//        user2.setLogin(USER_LOGIN_2_REBECCA);
//
//        List<User> githubUsers = new ArrayList<>();
//        githubUsers.add(user);
//        githubUsers.add(user2);
//        UsersList usersList = new UsersList();
//        usersList.setItems(githubUsers);
//        return usersList;
//    }
//
//    private User user1FullDetails() {
//        User user = new User();
//        user.setLogin(USER_LOGIN_RIGGAROO);
//        user.setName("Rigs Franks");
//        user.setAvatarUrl("avatar_url");
//        user.setBio("Bio1");
//        return user;
//    }
//
//    private User user2FullDetails() {
//        User user = new User();
//        user.setLogin(USER_LOGIN_2_REBECCA);
//        user.setName("Rebecca Franks");
//        user.setAvatarUrl("avatar_url2");
//        user.setBio("Bio2");
//        return user;
//    }

//    @Test
//    public void searchUsers_200OkResponse_InvokesCorrectApiCalls() {
//        //Given
//        when(githubUserRestService.searchGithubUsers(anyString())).thenReturn(Observable.just(githubUserList()));
//        when(githubUserRestService.getUser(anyString()))
//                .thenReturn(Observable.just(user1FullDetails()), Observable.just(user2FullDetails()));
//
//        //When
//        TestSubscriber<List<User>> subscriber = new TestSubscriber<>();
//        userRepository.searchUsers(USER_LOGIN_RIGGAROO).subscribe(subscriber);
//
//        //Then
//        subscriber.awaitTerminalEvent();
//        subscriber.assertNoErrors();
//
//        List<List<User>> onNextEvents = subscriber.getOnNextEvents();
//        List<User> users = onNextEvents.get(0);
//        Assert.assertEquals(USER_LOGIN_RIGGAROO, users.get(0).getLogin());
//        Assert.assertEquals(USER_LOGIN_2_REBECCA, users.get(1).getLogin());
//        verify(githubUserRestService).searchGithubUsers(USER_LOGIN_RIGGAROO);
//        verify(githubUserRestService).getUser(USER_LOGIN_RIGGAROO);
//        verify(githubUserRestService).getUser(USER_LOGIN_2_REBECCA);
//    }

}