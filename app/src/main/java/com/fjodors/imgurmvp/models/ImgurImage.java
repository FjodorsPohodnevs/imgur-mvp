package com.fjodors.imgurmvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgurImage extends ImgurBaseItem {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("animated")
    @Expose
    public boolean animated;
    @SerializedName("width")
    @Expose
    public int width;
    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("size")
    @Expose
    public int size;
    @SerializedName("comment_count")
    @Expose
    public int commentCount;
    @SerializedName("bandwidth")
    @Expose
    public int bandwidth;
    @SerializedName("vote")
    @Expose
    public Object vote;
    @SerializedName("section")
    @Expose
    public String section;
    @SerializedName("account_url")
    @Expose
    public String accountUrl;
    @SerializedName("account_id")
    @Expose
    public int accountId;

    public String getType() {
        return type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return size;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public Object getVote() {
        return vote;
    }

    public String getSection() {
        return section;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public int getAccountId() {
        return accountId;
    }
}