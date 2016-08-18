package com.fjodors.imgurmvp.api;

import com.fjodors.imgurmvp.api.responses.GalleryResponse;
import com.fjodors.imgurmvp.api.responses.ImageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImgurApiService {
    @GET("gallery/{section}/{sort}/{page}?showViral=true")
    Call<GalleryResponse> getMainGallery(@Path("section") String section,
                                         @Path("sort") String sort,
                                         @Path("page") String page);

    @GET("topics/{topic_id}/{sort}/{page}")
    Call<GalleryResponse> getTopic(@Path("topic_id") String topicId,
                                   @Path("sort") String sort,
                                   @Path("page") String page);

    @GET("album/{id}/images")
    Call<ImageResponse> getAlbumImages(@Path("id") String albumId);


}
