package com.example.movie;

public class Movie {
    private String year;
    private int stars;
    private String title;
    private String director;
    private String genre;


    public Movie(String title, String director, String genre, String year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.stars = 0;
    }

    public Movie(Movie movie) {
        this.title = movie.getTitle();
        this.director = movie.getDirector();
        this.genre = movie.getGenre();
        this.year = movie.getYear();
        this.stars = movie.getRating();
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public int getRating() {
        return stars;
    }

    public void setRating(int rating) {
        this.stars = rating;
    }
}
