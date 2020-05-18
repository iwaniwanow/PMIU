package com.example.recyclerviewcontacts;


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

import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends DialogFragment implements View.OnClickListener {
    private EditText nameEditText;
    private EditText addressEditText;
    private EditText imageUrlEditText;
    private Button button;
    private AddContactListener AddContactListener;


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {

        return new BlankFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameEditText = view.findViewById(R.id.nameEditText);
        addressEditText = view.findViewById(R.id.adressEditText);
        imageUrlEditText = view.findViewById(R.id.urlEditText);
        button = view.findViewById(R.id.addContact);
        button.setOnClickListener(this);
        nameEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public void onAttach(Context context){
    super.onAttach(context);
    AddContactListener = (AddContactListener) context;
    }

    public void onClick(View view) {
        Contact contact = new Contact(
                addressEditText.getText().toString(),
                nameEditText.getText().toString(),
                imageUrlEditText.getText().toString()
        );
        AddContactListener.finishAdd(contact);
        dismiss();

    }
}
