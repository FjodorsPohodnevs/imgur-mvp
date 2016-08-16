package com.fjodors.imgurmvp.api.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
