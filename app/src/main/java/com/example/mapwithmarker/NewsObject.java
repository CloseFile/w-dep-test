package com.example.mapwithmarker;

public class NewsObject {
    private String newsTitle;
    private String newsText;
    private int imageId;

    public NewsObject(String newsTitle, String newsText) {
        this.newsTitle = newsTitle;
        this.newsText = newsText;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsText() {
        return newsText;
    }

    public int getImageId() {
        return imageId;
    }
}
