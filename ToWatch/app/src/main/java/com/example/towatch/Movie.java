package com.example.towatch;

public class Movie {
    private String poster_path;
    private String title;
    private int genres[];
    private String original_language;
    private String overView;
    private String release_Date;
    private double vote_average;
    private long vote_count;
    private long id;


    //getter and setter section
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int[] getGenres() {
        return genres;
    }
    public void setGenres(int[] genres) {
        this.genres = genres;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getOverView() {
        return overView;
    }
    public void setOverView(String overView) {
        this.overView = overView;
    }
    public String getRelease_Date() {
        return release_Date;
    }
    public void setRelease_Date(String release_Date) {
        this.release_Date = release_Date;
    }
    public double getVote_average() {
        return vote_average;
    }
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }
    public long getVote_count() {
        return vote_count;
    }
    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }
    public String getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    //other methods




}
