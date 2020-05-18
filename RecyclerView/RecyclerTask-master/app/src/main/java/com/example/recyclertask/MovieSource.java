package com.example.recyclertask;

import java.util.ArrayList;

public class MovieSource {
    public static ArrayList<Movie> generateMovieList(){
        ArrayList<Movie>movies=new ArrayList<Movie>();
        movies.add(new Movie("Rambo purva kruv","Komediq",1980));
        movies.add(new Movie("Rambo 2","Drama",1982));
        movies.add(new Movie("Rambo posledna kruv","Ekshan",2019));
        return movies;


    }

}
