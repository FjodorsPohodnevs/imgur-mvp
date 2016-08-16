package com.fjodors.imgurmvp.api.responses;

import com.fjodors.imgurmvp.models.ImgurAlbumModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class AlbumResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    public List<ImgurAlbumModel> data;

    public List<ImgurAlbumModel> getData() {
        return data;
    }
}
