package com.example.arrayadapter;

import java.util.ArrayList;
import java.util.List;

public class AnimalStorage {
public static List<Animal> getAnmals(){
List<Animal>myList=new ArrayList<>();
myList.add(new Animal("android",R.drawable.android));
myList.add(new Animal("gushter",R.drawable.gushter));
myList.add(new Animal("labrador",R.drawable.labrador));

return myList;

}

}
