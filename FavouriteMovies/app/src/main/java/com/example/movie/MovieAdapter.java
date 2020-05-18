package com.example.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>  {
    private ArrayList<Movie> movies;

    public MovieAdapter(ArrayList<Movie>movies){
        this.movies=movies;
    }






    public MovieViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.card_view,parent,false);
        return new MovieViewHolder(movieView);
    }

    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.setMovieName(movie.getTitle());
        holder.setMovieDirector(movie.getDirector());
        holder.setMovieGenre(movie.getGenre());
        holder.setMovieYear(movie.getYear());
        holder.setMovieRating(movie.getRating());
    }

    public ArrayList<Movie> getMovies(){return this.movies;}
    public int getItemCount(){return movies.size();}

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
        notifyItemChanged(this.movies.size()-1);
    }

    public void deleteMovie(String name){
        for(int i =0; i<movies.size(); i++){
            if(movies.get(i).getTitle().equals(name)){
                movies.remove(i);
            }
        }
        notifyDataSetChanged();

    }




}
