package com.example.towatch.adapter;

import static android.view.LayoutInflater.from;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.towatch.R;
import com.example.towatch.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.movieViewHolder> {
    private ArrayList<Movie> moviesList;

    public MovieAdapter(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_movie, parent , false);
        return new movieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        holder.textView.setText(moviesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    //View holder
    class movieViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public movieViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.movie_textView1);
        }
    }
}
