package com.example.movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements MovieStarsChanged,DeleteMovieListener {
    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.RecyclerView);
        this.adapter=new MovieAdapter(MovieRepository.getMovieList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.addMovie);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                addMovie blankFragment = addMovie.newInstance();
                blankFragment.show(fm,"fragment_add_movie");
            }
        });

        FloatingActionButton delete = findViewById(R.id.deleteMovie);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm2 = getSupportFragmentManager();
                DeleteMovie blankFragment = DeleteMovie.newInstance();
                blankFragment.show(fm2,"fragment_delete_movie");
            }
        });


    }

    public void starsChanged(Movie movie){
        this.adapter.addMovie(movie);
    }


    @Override
    public void onDeleteClick(String name) {
        this.adapter.deleteMovie(name);
    }
}
