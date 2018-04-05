package com.knightcube.samples.newsreaderapp;

public class NewsStories {

    private String newsTitle;
    private String newsDate;
    private String newsUrl;
    private String newsSectionName;

    public NewsStories(String newsTitle, String newsDate, String newsUrl, String newsSectionName) {
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsUrl = newsUrl;
        this.newsSectionName = newsSectionName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public String getNewsSectionName() {
        return newsSectionName;
    }
}
