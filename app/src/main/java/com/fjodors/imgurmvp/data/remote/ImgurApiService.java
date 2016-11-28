package com.fjodors.imgurmvp.data.remote;

import com.fjodors.imgurmvp.data.remote.model.GalleryResponse;
import com.fjodors.imgurmvp.data.remote.model.ImageResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImgurApiService {
    @GET("gallery/{section}/{sort}/{page}")
    Observable<GalleryResponse> getMainGallery(@Path("section") String section,
                                               @Path("sort") String sort,
                                               @Path("page") String page,
                                               @Query("showViral") boolean showViral);


    @GET("topics/{topic_id}/{sort}/{page}")
    Observable<GalleryResponse> getTopic(@Path("topic_id") String topicId,
                                         @Path("sort") String sort,
                                         @Path("page") String page);

    @GET("album/{id}/images")
    Observable<ImageResponse> getAlbumImages(@Path("id") String albumId);


}
