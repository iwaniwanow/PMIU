package com.example.recyclertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Movie>movies;
    private Context context;

    public CustomAdapter(List<Movie>movies){
        this.movies=movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.rowlayout,parent,false);
        ViewHolder viewHolder= new ViewHolder((movieView));
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        final Movie movie = movies.get(position);

        holder.setHeadlight("Name of movie : "+movie.getHeadlight());
        holder.setGanr("Ganr of movie : "+movie.getGanr());
        holder.setYear("Movie release date : "+movie.getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, movie.getHeadlight() + ", " + movie.getGanr() + ", "+ movie.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount(){
        return movies.size();
    }
}
