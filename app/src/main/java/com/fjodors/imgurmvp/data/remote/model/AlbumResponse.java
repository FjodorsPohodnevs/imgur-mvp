package com.fjodors.imgurmvp.data.remote.model;

import com.fjodors.imgurmvp.model.ImgurAlbum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class AlbumResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    public List<ImgurAlbum> data;

    public List<ImgurAlbum> getData() {
        return data;
    }
}
