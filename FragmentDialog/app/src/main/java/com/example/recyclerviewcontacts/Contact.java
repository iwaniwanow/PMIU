package com.example.recyclerviewcontacts;

public class Contact {
    private String address;
    private String name;
    private String id;

    public Contact(String address, String name,String id) {
        this.address = address;
        this.name = name;
        this.id = id;

    }

    public Contact(Contact contact){
        this.address=contact.getAddress();
        this.name=contact.getName();
        this.id=contact.getId();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
