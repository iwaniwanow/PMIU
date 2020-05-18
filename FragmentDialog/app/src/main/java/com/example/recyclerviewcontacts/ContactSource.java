package com.example.recyclerviewcontacts;

import java.util.ArrayList;

public class ContactSource {
    private static ArrayList<Contact>contacts;

     static {
        contacts=new ArrayList<Contact>();
        contacts.add(new Contact("street 9","Ivan","https://ibb.co/z6cgv57"));
         contacts.add(new Contact("street 922","Petkan","https://www.google.com/search?q=contact+picture&sxsrf=ALeKk00z-nh26tFcSlwefsQdY03RliKQug:1585907179251&tbm=isch&source=iu&ictx=1&fir=Rali7qEnuZw-_M%253A%252CH0lh3eM-ZIX4LM%252C_&vet=1&usg=AI4_-kS1ERkVI55VyntsJ0X1j1pitWi8lA&sa=X&ved=2ahUKEwiOmsPQ_MvoAhXzrnEKHTQnAvkQ9QEwCXoECAYQLg#imgrc=Rali7qEnuZw-_M:"));
     }

    public static ArrayList<Contact> getContacts(){return contacts;}

    public static void setContact(ArrayList<Contact> contactsArg){
        ContactSource.contacts=contactsArg;
    }
}
