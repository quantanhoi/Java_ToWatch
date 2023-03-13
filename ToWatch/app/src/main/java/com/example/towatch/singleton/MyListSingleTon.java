package com.example.towatch.singleton;

import android.mtp.MtpObjectInfo;

import com.example.towatch.model.Movie;

import java.util.ArrayList;

public class MyListSingleTon {
    private static MyListSingleTon instance;
    private ArrayList<Movie> myList;
    private MyListSingleTon() {

    }

    public static MyListSingleTon getInstance() {
        if(instance == null ) {
            instance = new MyListSingleTon();
        }
        return instance;
    }
    public void addMovie(Movie movie) {
        myList.add(movie);
    }
    public void removeMovie(Movie movie) {
        for(Movie m : myList) {
            if(m.getId()== movie.getId()) {
                myList.remove(m);
                return;
            }
        }
    }
    public ArrayList<Movie> getMyList() {
        return myList;
    }


}
