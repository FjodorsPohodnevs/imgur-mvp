package com.fjodors.imgurmvp;

import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/10/2016.
 */
public class ImgurGalleryImage {

    public List<Data> data;
    public boolean success;
    public int status;

    public static class Data {
        public String id;
        public String title;
        public Object description;
        public long datetime;
        public String type;
        public boolean animated;
        public int width;
        public int height;
        public int size;
        public int views;
        public int commentCount;
        public long bandwidth;
        public Object vote;
        public String section;
        public String accountUrl;
        public int accountId;
        public int ups;
        public int downs;
        public int points;
        public long score;
        public boolean isAlbum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isAnimated() {
            return animated;
        }

        public void setAnimated(boolean animated) {
            this.animated = animated;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public long getBandwidth() {
            return bandwidth;
        }

        public void setBandwidth(long bandwidth) {
            this.bandwidth = bandwidth;
        }

        public Object getVote() {
            return vote;
        }

        public void setVote(Object vote) {
            this.vote = vote;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getAccountUrl() {
            return accountUrl;
        }

        public void setAccountUrl(String accountUrl) {
            this.accountUrl = accountUrl;
        }

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public int getUps() {
            return ups;
        }

        public void setUps(int ups) {
            this.ups = ups;
        }

        public int getDowns() {
            return downs;
        }

        public void setDowns(int downs) {
            this.downs = downs;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public boolean isAlbum() {
            return isAlbum;
        }

        public void setAlbum(boolean album) {
            isAlbum = album;
        }
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
