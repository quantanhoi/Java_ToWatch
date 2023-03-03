package com.example.towatch.service;
import retrofit2.Call;
import retrofit2.http.GET;
import com.example.towatch.model.*;
public interface getMovieDataService {
    //Retrofit interface
    @GET("movie/popular?api_key=72de4e9385d9a050ba414029f5fb69bd&language=en-US&page=1")
    Call<Result> getResult();
}
