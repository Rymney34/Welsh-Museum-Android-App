package com.example.welshmuseumapp;

public class LibraryModel {
    LibraryCardHolder holder;
    int image;
    String title;
    String url;

    public LibraryModel(int image, String title, String url) {
        this.image = image;
        this.title = title;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {

        return title;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {

        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
