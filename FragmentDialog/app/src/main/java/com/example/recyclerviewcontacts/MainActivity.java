package com.example.recyclerviewcontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddContactListener {
    private ContactAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView = findViewById(R.id.contact_recycler);

        this.adapter = new ContactAdapter(ContactSource.getContacts());


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.addContact);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                BlankFragment blankFragment = BlankFragment.newInstance();
                blankFragment.show(fm,"fragment_blank");
            }
        });

    }

    @Override
    public void finishAdd(Contact contact) {
        this.adapter.addContact(contact);
    }

    // TO DO transfer trought creator metod
   // public void getResult(String name, String adress) {
        //adapter.addContact(name, adress);
  //  }

}
