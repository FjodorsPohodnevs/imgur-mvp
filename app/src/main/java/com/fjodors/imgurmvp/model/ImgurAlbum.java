package com.fjodors.imgurmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ImgurAlbum extends ImgurBaseItem {
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("account_url")
    @Expose
    private String accountUrl;
    @SerializedName("account_id")
    @Expose
    private int accountId;
    @SerializedName("privacy")
    @Expose
    private String privacy;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("vote")
    @Expose
    private Object vote;
    @SerializedName("comment_count")
    @Expose
    private int commentCount;
    @SerializedName("images_count")
    @Expose
    private int imagesCount;
    @SerializedName("images")
    @Expose
    private List<ImgurImage> images = new ArrayList<>();

    public String getCover() {
        return cover;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getPrivacy() {
        return privacy;
    }

    public String getLayout() {
        return layout;
    }

    public Object getVote() {
        return vote;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getImagesCount() {
        return imagesCount;
    }

    public List<ImgurImage> getImages() {
        return images;
    }
}