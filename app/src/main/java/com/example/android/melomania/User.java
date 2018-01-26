package com.example.android.melomania;

import java.io.Serializable;

/**
 * Created by Demo on 2018-01-22.
 */

public class User implements Serializable {

    private String name;
    private int img;

    public User(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
