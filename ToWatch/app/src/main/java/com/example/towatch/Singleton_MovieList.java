package com.example.towatch;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.io.*;
import org.json.*;



public class Singleton_MovieList {
    private static final String API_KEY_v3 = "72de4e9385d9a050ba414029f5fb69bd";
    private static final String API_READ_ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MmRlNGU5Mzg1ZDlhMDUwYmE0MTQwMjlmNWZiNjliZCIsInN1YiI6IjYzZmE4NTBmOTZlMzBiMDBiZTU5YTAxOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.WvnY5_T_zMvG6GQn9jXkCghHCbPBtOEZN61sQRvR-D4";
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String LANGUAGE = "&language="; // for example en-US: &language=en-US
    private static final String PAGE = "&page=";  //for example page 1: &page=1
    private static final String MOVIE_SECTION = "movie/";
    private static final String POPULAR_SECTION = "popular";
    private static final String API_QUERY = "?api_key=";

    //example: https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1


    public static void setInstance(Singleton_MovieList instance) {
        Singleton_MovieList.instance = instance;
    }
    public static void parseJson() {
        File jsonFile = new File("response.json");

        try {
            FileReader reader = new FileReader(jsonFile);
            StringBuilder sb = new StringBuilder();
            int c = reader.read();
            while (c != -1) {
                sb.append((char) c);
                c = reader.read();
            }
            String jsonString = sb.toString();
            JSONTokener tokener = new JSONTokener(jsonString);
            JSONObject jsonObject = new JSONObject(tokener);
            JSONArray resultArray = jsonObject.getJSONArray("result");
            for(int i = 0; i < resultArray.length(); i++) {
                JSONObject movieObject = resultArray.getJSONObject(i);
                String title = movieObject.getString("title");
                System.out.println(title);
            }
        }
        catch (FileNotFoundException e) {
            // Handle the exception
            e.printStackTrace();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private static Singleton_MovieList instance;
    private Singleton_MovieList() {}

    public static Singleton_MovieList getInstance() {
        if(getInstance() == null) {
            instance = new Singleton_MovieList();
        }
        return  instance;
    }
    

    public void addNewMovie(Movie movie) {
        this.movieArrayList.add(movie);
    }
    public Movie findMovieByID(long id) {
        for(Movie m: movieArrayList) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }
    public ArrayList<Movie> getMovieListByGenre(int genre) {
        ArrayList<Movie> mList = new ArrayList<>();
        for(Movie m : movieArrayList) {
            for(int g : m.getGenres()) {
                if(g == genre) {
                    mList.add(m);
                    continue;
                }
            }
        }
        return mList;
    }
    public void saveMovieList(Context context) {
        JSONArray savedMovieList = new JSONArray();
        for(Movie m : movieArrayList) {
            JSONObject movieDetails = new JSONObject();
            try{
                movieDetails.put("title", m.getTitle());
                movieDetails.put("id", m.getId());
                movieDetails.put("release_data", m.getRelease_Date());
                movieDetails.put("original_language", m.getOriginal_language());
                movieDetails.put("overview", m.getOverView());
                movieDetails.put("poster_path", m.getPoster_path());
                movieDetails.put("vote_average", m.getVote_average());
                movieDetails.put("vote_count", m.getVote_count());
                for(int genre : m.getGenres()) {
                    movieDetails.put("genre", genre);
                }
                savedMovieList.put(movieDetails);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream outputStream = context.openFileOutput("movieList.json", Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(savedMovieList.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
