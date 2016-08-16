package com.fjodors.imgurmvp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurBaseItemModel implements Serializable {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("datetime")
    @Expose
    public int datetime;
    @SerializedName("views")
    @Expose
    public int views;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("ups")
    @Expose
    public int ups;
    @SerializedName("downs")
    @Expose
    public int downs;
    @SerializedName("points")
    @Expose
    public int points;
    @SerializedName("score")
    @Expose
    public int score;
    @SerializedName("is_album")
    @Expose
    public boolean isAlbum;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Object getDescription() {
        return description;
    }

    public int getDatetime() {
        return datetime;
    }

    public int getViews() {
        return views;
    }

    public String getLink() {
        return link;
    }

    public int getUps() {
        return ups;
    }

    public int getDowns() {
        return downs;
    }

    public int getPoints() {
        return points;
    }

    public int getScore() {
        return score;
    }

    public boolean isAlbum() {
        return isAlbum;
    }
}
