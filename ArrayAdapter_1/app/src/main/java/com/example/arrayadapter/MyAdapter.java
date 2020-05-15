package com.example.arrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.arrayadapter.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Animal> {
    private Context context;


    public MyAdapter(Context context, List<Animal> animalsArg) {
        super(context, 0, animalsArg);
        this.context= context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Animal animal = getItem(position);


        //LayoutInflater inflater =(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.item, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.textView3);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        textView.setText(animal.getName());
        imageView.setImageResource(animal.getID());

        // textView.setText(animals.get(0).getName());
       // imageView.setImageResource(Integer.parseInt(animals.get(0).getID()));



        return convertView;
    }
}
