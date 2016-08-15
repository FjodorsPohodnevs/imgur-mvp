package com.fjodors.imgurmvp.images;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImagesApiInterface {
    @GET("topics/{topic_id}/{sort}/{page}")
    Call<ImgurGalleryModel> getTopic(@Path("topic_id") String topicId,
                                     @Path("sort") String sort,
                                     @Path("page") String page);
}
