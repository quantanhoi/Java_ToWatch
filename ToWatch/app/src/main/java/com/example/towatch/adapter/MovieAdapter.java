package com.example.towatch.adapter;

import static android.view.LayoutInflater.from;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.towatch.R;
import com.example.towatch.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.movieViewHolder> {
    private ArrayList<Movie> moviesList;
    private Context context;
    String Image_base_url = "https://image.tmdb.org/t/p/w500";

    public MovieAdapter(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        View view = layoutInflater.inflate(R.layout.recycleview_movie, parent , false);
        return new movieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        holder.textView.setText(moviesList.get(position).getTitle());
        String imageURL = "" + Image_base_url + moviesList.get(position).getPosterPath();
        System.out.println(imageURL);

        //TODO: check context
        Glide
                .with(context)
                .load(imageURL)
                .error(R.drawable.ic_baseline_android_24)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    //View holder
    class movieViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public movieViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.movie_textView1);

            //TODO: fix imageView and glide
            imageView = itemView.findViewById(R.id.filmImage);
        }
    }
}
