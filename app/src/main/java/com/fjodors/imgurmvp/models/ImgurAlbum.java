package com.fjodors.imgurmvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ImgurAlbum extends ImgurBaseItem {
    @SerializedName("cover")
    @Expose
    public String cover;
    @SerializedName("account_url")
    @Expose
    public String accountUrl;
    @SerializedName("account_id")
    @Expose
    public int accountId;
    @SerializedName("privacy")
    @Expose
    public String privacy;
    @SerializedName("layout")
    @Expose
    public String layout;
    @SerializedName("vote")
    @Expose
    public Object vote;
    @SerializedName("comment_count")
    @Expose
    public int commentCount;
    @SerializedName("images_count")
    @Expose
    public int imagesCount;
//    @SerializedName("images")
//    @Expose
    public List<ImgurImage> images = new ArrayList<>();

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