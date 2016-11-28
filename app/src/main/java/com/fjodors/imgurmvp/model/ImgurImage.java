package com.fjodors.imgurmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImgurImage extends ImgurBaseItem {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("animated")
    @Expose
    private boolean animated;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("comment_count")
    @Expose
    private int commentCount;
    @SerializedName("bandwidth")
    @Expose
    private long bandwidth;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("account_url")
    @Expose
    private String accountUrl;
    @SerializedName("account_id")
    @Expose
    private int accountId;

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

    public long getBandwidth() {
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