package com.example.movie;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addMovie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addMovie extends DialogFragment implements View.OnClickListener {
    private EditText title;
    private EditText genre;
    private EditText year;
    private EditText director;

    private Button addButton;

    private MovieStarsChanged MovieStarsChanged;


    public addMovie() {
        // Required empty public constructor
    }

    public static addMovie newInstance (){return new addMovie();}


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_movie,container,false);
    }

    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        title=view.findViewById(R.id.nameEditText);
        genre=view.findViewById(R.id.genreEditText);
        year=view.findViewById(R.id.yearEditText);
        director=view.findViewById(R.id.directorEditText);
        addButton=view.findViewById(R.id.add);
        addButton.setOnClickListener((View.OnClickListener) this);
        title.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

    public void onAttach(Context context){
        super.onAttach(context);
        MovieStarsChanged=(MovieStarsChanged) context;
    }

    public void onClick(View view) {
        Movie movie = new Movie(
                title.getText().toString(), director.getText().toString(), genre.getText().toString(),
                year.getText().toString()
        );
        MovieStarsChanged.starsChanged(movie);
        dismiss();

    }


}