package com.example.android.melomania;

/**
 * Created by Demo on 2018-01-21.
 */

public class Song {
    private int songImg;
    private String songName;
    private String signerName;

    public Song() {
        songName = signerName = "";
    }

    public Song(int songImg, String songName, String signerName) {
        this.songImg = songImg;
        this.songName = songName;
        this.signerName = signerName;
    }

    public int getSongImg() {
        return songImg;
    }

    public void setSongImg(int songImg) {
        this.songImg = songImg;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }


}
