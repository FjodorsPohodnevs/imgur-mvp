package com.fjodors.imgurmvp.images;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImagesApiInterface {
    @GET("gallery/hot/viral/1?showViral=true")
    Call<ImagesModel> getRandomGallery();
}
