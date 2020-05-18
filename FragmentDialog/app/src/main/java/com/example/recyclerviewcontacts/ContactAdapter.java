package com.example.recyclerviewcontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactView> {
    private ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {

        this.contacts = contacts;
    }

    public ContactView onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.card_view, parent, false);
        return new ContactView(contactView);
    }

    public void onBindViewHolder(ContactView holder, int position) {
        Contact contact = this.contacts.get(position);
        holder.setAdress(contact.getAddress());
        holder.setImage(contact.getId());
        holder.setContact(contact.getName());



       // holder.itemView.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
          //      Toast.makeText(context, contact.getName() + ", " + contact.getAddress(), Toast.LENGTH_SHORT).show();
           // }
       // });
    }

    public int getItemCount() {
      return  contacts.size();
    }

    public void addContact(Contact contact) {
        this.contacts.add(new Contact(contact));
        notifyItemChanged(this.contacts.size()-1);
    }
}
