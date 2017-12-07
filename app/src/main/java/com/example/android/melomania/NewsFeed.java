package com.example.android.melomania;

/**
 * Created by Demo on 2017-12-04.
 */

public class NewsFeed {
    private int profileImg;
    private String userName;
    private String songName;
    private String singerName;
    private boolean isLiked;
    private String action;

    public NewsFeed(int profileImg, String userName, String songName, String singerName, boolean isLiked, String action) {
        this.profileImg = profileImg;
        this.userName = userName;
        this.songName = songName;
        this.singerName = singerName;
        this.isLiked = isLiked;
        this.action = action;
    }

    public NewsFeed() {
        userName=singerName=songName=action="";
        isLiked=false;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
