package com.example.recyclertask;

public class Movie {
    private String ganr;
    private String headlight;
    private int year;

    public Movie(String headlightArg,String ganrArg,int yearArg){
        this.headlight=headlightArg;
        this.year=yearArg;
        this.ganr=ganrArg;


    }

    public String getGanr() {
        return ganr;
    }

    public void setGanr(String ganr) {
        this.ganr = ganr;
    }

    public String getHeadlight() {
        return headlight;
    }

    public void setHeadlight(String headlight) {
        this.headlight = headlight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
