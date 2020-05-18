package com.example.recyclertask;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclertask.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView headlight;
    private TextView ganr;
    private TextView year;

    public ViewHolder( View itemView){
    super(itemView);
    headlight=itemView.findViewById(R.id.textView);
    ganr=itemView.findViewById(R.id.textView2);
    year=itemView.findViewById(R.id.textView3);
    }

    public TextView getHeadlight() {
        return headlight;
    }

    public void setHeadlight(String headlight) {
        this.headlight.setText(headlight.toString());
    }

    public TextView getGanr() {
        return ganr;
    }

    public void setGanr(String ganr) {
        this.ganr.setText(ganr.toString());
    }

    public TextView getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year.setText(year.toString());
    }
}
