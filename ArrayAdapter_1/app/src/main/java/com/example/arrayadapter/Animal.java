package com.example.arrayadapter;

import android.app.Application;

public class Animal extends Application {
    private String name;
    private int id;

    public String getName() {
        return this.name;
    }


    public Animal(String nameArg, int idArg) {
        this.name = nameArg;
        this.id = idArg;
    }

    public int getID() {
        return this.id;
    }


    public void setName(String nameArg) {
    this.name=nameArg;

    }

    public void setId(int idArg)
    {
        this.id=idArg;
    }
}
