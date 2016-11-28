package com.fjodors.imgurmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurBaseItem implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("datetime")
    @Expose
    private int datetime;
    @SerializedName("views")
    @Expose
    private int views;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("ups")
    @Expose
    private int ups;
    @SerializedName("downs")
    @Expose
    private int downs;
    @SerializedName("points")
    @Expose
    private int points;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("is_album")
    @Expose
    private boolean isAlbum;

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
