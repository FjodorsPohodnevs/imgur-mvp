package com.fjodors.imgurmvp.data.remote.model;

import com.fjodors.imgurmvp.model.ImgurBaseItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class GalleryResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    public List<ImgurBaseItem> data;

    public GalleryResponse(List<ImgurBaseItem> data) {
        this.data = data;
    }

    public List<ImgurBaseItem> getData() {
        return data;
    }
}
