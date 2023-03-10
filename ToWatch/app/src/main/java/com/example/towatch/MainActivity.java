package com.example.towatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.towatch.adapter.MovieAdapter;
import com.example.towatch.model.Movie;
import com.example.towatch.model.Result;
import com.example.towatch.service.RetrofitInstance;
import com.example.towatch.service.getMovieDataService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
//    ArrayList<Movie> movies;
//    MovieAdapter adapter;
//    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;
    MyListFragment myListFragment = new MyListFragment();
    PopularFragment popularFragment = new PopularFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        recyclerView = findViewById(R.id.recyclerView_movie1);
//        GetMovies();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.PopularFilm);
    }

//    private Object GetMovies() {
//        getMovieDataService getMovieDataService = RetrofitInstance.getService();
//        Call<Result> call = getMovieDataService.getResult();
//        call.enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                Result result = response.body();
//                if(result != null && result.getResults() != null) {
//                    movies = (ArrayList<Movie>) result.getResults();
//                    for(Movie m : movies) {
//                        System.out.println(m.getTitle());
//                    }
//                    ViewData();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//
//            }
//        });
//        return movies;
//    }
//
//    private void ViewData() {
//        adapter = new MovieAdapter(movies);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                return true;
            case R.id.PopularFilm:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, popularFragment).commit();
                return true;
            case R.id.MyList:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, myListFragment).commit();
                return true;

        }
        return false;
    }
}