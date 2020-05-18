package com.example.movie;

import java.util.ArrayList;


public class MovieRepository {


    private static ArrayList<Movie> movieList;

   static {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Rambo", "Silvester Stalone", "Action", "1996"));
        movieList.add(new Movie("Rambo first blood", "Silvester Stalone", "Action", "2000"));
        movieList.add(new Movie("Walking Dead", "somebody", "Series", "2010"));
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }



}
