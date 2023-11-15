package com.pluralsight;

import java.util.LinkedList;
import java.util.List;

public class FixedList<T> {
    /*---------------VARIABLES---------------*/

    private List<T> items;
    private int maxSize;

    /*--------------CONSTRUCTORS-------------*/

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        items = new LinkedList<>();
    }

    /*------------GETTERS/SETTERS------------*/

    public List<T> getItems() {
        return items;
    }

    /*---------------FUNCTIONS---------------*/

    public void add (T item){
        if(items.size()<maxSize){
            items.add(item);
        }
        else{
            System.out.println("List is full!");
        }
    }



}
