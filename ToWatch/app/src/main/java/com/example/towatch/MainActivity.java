package com.example.towatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.towatch.model.Movie;
import com.example.towatch.model.Result;
import com.example.towatch.service.RetrofitInstance;
import com.example.towatch.service.getMovieDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movies;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetMovies();
    }

    private Object GetMovies() {
        getMovieDataService getMovieDataService = RetrofitInstance.getService();
        Call<Result> call = getMovieDataService.getResult();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResults() != null) {
                    movies = (ArrayList<Movie>) result.getResults();
                    for(Movie m : movies) {
                        System.out.println(m.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return movies;
    }
}