package com.fjodors.imgurmvp.api.responses;

import com.fjodors.imgurmvp.models.ImgurBaseItemModel;
import com.fjodors.imgurmvp.models.ImgurImageModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class GalleryResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    public List<ImgurBaseItemModel> data;

    public List<ImgurBaseItemModel> getData() {
        return data;
    }
}
