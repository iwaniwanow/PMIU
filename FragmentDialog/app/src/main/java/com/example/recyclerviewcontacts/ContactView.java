package com.example.recyclerviewcontacts;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ContactView extends RecyclerView.ViewHolder {
    private TextView contact;
    private ImageView picture;
    private TextView adress;

    public ContactView(View itemView){
        super(itemView);
        contact =itemView.findViewById(R.id.nameTextView);
        picture =itemView.findViewById(R.id.imageView);
        adress = itemView.findViewById(R.id.adressTextView);
    }

public void setImage(String url){
    Picasso.get()
            .load(url)
            .placeholder(R.mipmap.ic_launcher)
            .resize(100,100)
            .into(this.picture);

}
    public void setContact(String contact){
        this.contact.setText(contact);
    }

    public TextView getContact(){
        return contact;
    }


    public TextView getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.setText(adress);
    }
}
