package com.example.movie;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView movieName;
    private TextView movieDirector;
    private TextView movieGenre;
    private TextView movieYear;
    private RatingBar movieRating;

    private AdapterView.OnItemClickListener listener;





    public MovieViewHolder(final View itemView){
        super(itemView);
        movieName=itemView.findViewById(R.id.nameTextView);
        movieDirector=itemView.findViewById(R.id.directorTextView);
        movieGenre=itemView.findViewById(R.id.genreTextView);
        movieYear=itemView.findViewById(R.id.yearTextView);
        movieRating=itemView.findViewById(R.id.ratingBar);

    }



    public void setMovieName(String movieName){this.movieName.setText("Movie name : "+movieName);}
    public void setMovieDirector(String director){this.movieDirector.setText("Director name "+director);}
    public void setMovieGenre(String genre){this.movieGenre.setText("Movie Genre : "+genre);}
    public void setMovieYear(String year){this.movieYear.setText("Moive year"+year);}
    public void setMovieRating(int rating) { this.movieRating.setRating(rating);}


}
