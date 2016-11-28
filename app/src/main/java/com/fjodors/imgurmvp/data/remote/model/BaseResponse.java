package com.fjodors.imgurmvp.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fjodors on 17.08.2016.
 */
public class BaseResponse {

    @SerializedName("success")
    @Expose
    public boolean success;
    @SerializedName("status")
    @Expose
    public int status;

    public boolean isSuccess() {
        return success;
    }

    public int getStatus() {
        return status;
    }
}
