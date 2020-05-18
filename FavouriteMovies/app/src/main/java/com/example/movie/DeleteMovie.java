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
 * Use the {@link DeleteMovie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteMovie extends DialogFragment implements View.OnClickListener {

        private EditText name;
        private Button removeButton;
        private Button cancelButton;
        private DeleteMovieListener deleteMovieListener;


    public DeleteMovie() {
            // Required empty public constructor
        }

        public static DeleteMovie newInstance (){return new DeleteMovie();}



        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_delete_movie,container,false);
        }

        public void onViewCreated(View view,Bundle savedInstanceState){
            super.onViewCreated(view,savedInstanceState);
            name=view.findViewById(R.id.nameDeleteEditText);
            removeButton=view.findViewById(R.id.Remove);
            cancelButton=view.findViewById(R.id.cancel);
            name.requestFocus();
            getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteMovieListener.onDeleteClick(name.getText().toString());
                    dismiss();
                }
            });

            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

        }

        public void onAttach(Context context){
            super.onAttach(context);
            deleteMovieListener=(DeleteMovieListener) context;
        }


    @Override
    public void onClick(View v) {

    }
}
