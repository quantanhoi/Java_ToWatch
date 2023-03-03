package com.example.towatch.service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.*;
public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/";

    //Singleton Pattern that create an instance of retrofit
    public static getMovieDataService getService() {
        if(retrofit == null ) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(getMovieDataService.class);
    }

}
