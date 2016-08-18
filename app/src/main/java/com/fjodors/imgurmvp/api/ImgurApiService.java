package com.fjodors.imgurmvp.api;

import com.fjodors.imgurmvp.api.responses.GalleryResponse;
import com.fjodors.imgurmvp.api.responses.ImageResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImgurApiService {
    @GET("gallery/{section}/{sort}/{page}?showViral=true")
    Observable<GalleryResponse> getMainGallery(@Path("section") String section,
                                               @Path("sort") String sort,
                                               @Path("page") String page);

    @GET("topics/{topic_id}/{sort}/{page}")
    Observable<GalleryResponse> getTopic(@Path("topic_id") String topicId,
                                   @Path("sort") String sort,
                                   @Path("page") String page);

    @GET("album/{id}/images")
    Observable<ImageResponse> getAlbumImages(@Path("id") String albumId);


}
