package com.fjodors.imgurmvp.images;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurGalleryModel {

    public List<Data> data;
    public boolean success;
    public int status;

    public static class Data implements Serializable {
        public String id;
        public String title;
        public Object description;
        public long datetime;
        public String cover;
        public int coverWidth;
        public int coverHeight;
        public String accountUrl;
        public int accountId;
        public String privacy;
        public String layout;
        public int views;
        public String link;
        public int ups;
        public int downs;
        public int points;
        public int score;
        public boolean isAlbum;
        public Object vote;
        public boolean favorite;
        public boolean nsfw;
        public String section;
        public int commentCount;
        public String topic;
        public int topicId;
        public int imagesCount;
        public boolean inGallery;
        public boolean isAd;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public Object getDescription() {
            return description;
        }

        public long getDatetime() {
            return datetime;
        }

        public String getCover() {
            return cover;
        }

        public int getCoverWidth() {
            return coverWidth;
        }

        public int getCoverHeight() {
            return coverHeight;
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

        public Object getVote() {
            return vote;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public boolean isNsfw() {
            return nsfw;
        }

        public String getSection() {
            return section;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public String getTopic() {
            return topic;
        }

        public int getTopicId() {
            return topicId;
        }

        public int getImagesCount() {
            return imagesCount;
        }

        public boolean isInGallery() {
            return inGallery;
        }

        public boolean isAd() {
            return isAd;
        }
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
