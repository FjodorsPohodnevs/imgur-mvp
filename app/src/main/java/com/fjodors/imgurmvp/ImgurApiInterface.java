package com.fjodors.imgurmvp;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public interface ImgurApiInterface {
    @GET("gallery/random/random/")
    Call<ImgurGalleryImage> getGallery();
}
