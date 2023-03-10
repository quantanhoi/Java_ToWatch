package com.example.towatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.towatch.adapter.MovieAdapter;
import com.example.towatch.model.Movie;
import com.example.towatch.model.Result;
import com.example.towatch.service.RetrofitInstance;
import com.example.towatch.service.getMovieDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PopularFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopularFragment extends Fragment {

    ArrayList<Movie> movies;
    MovieAdapter adapter;
    RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PopularFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PopularFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PopularFragment newInstance(String param1, String param2) {
        PopularFragment fragment = new PopularFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        //set recycle view ID to recycle view id in this view (popular fragment) which inflated above
        //therefore recycleView = view.findViewId
        //if we assign id of recycleView before inflating, recycleView can't not find the id inside popularview
        //therefore recycleView is still null => error
        recyclerView = view.findViewById(R.id.recyclerView_movie1);
        GetMovies();
        return view;
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
                    ViewData();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return movies;
    }

    private void ViewData() {
        adapter = new MovieAdapter(movies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}