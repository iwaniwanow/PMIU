package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Animal> myList = new ArrayList<>();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        List<Animal>myAnimals =AnimalStorage.getAnmals();
        MyAdapter adapter = new MyAdapter(this,myAnimals);
        ListView listView= findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

//    public void onClick(View view){



        //TextView name = (TextView) findViewById(R.id.editText);
        //TextView pictureId = (TextView) findViewById(R.id.editText2);
      //  Animal myAnimal = new Animal(name.getText().toString(),pictureId.getText().toString());
       // myList.add(myAnimal);
        //MyAdapter testAdapter = new MyAdapter(this,myList);
        //ListView listView =(ListView) findViewById(R.id.listview0);
        //listView.setAdapter(testAdapter);

  //  }

}
