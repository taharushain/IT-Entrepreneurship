package com.example.listviewdemo;

/**
 * Created by taharushain on 3/5/17.
 */

public class StudentItem {

    private String name;

    public StudentItem(String name) {
        this.name = name;
    }

    public StudentItem() {
        name = "John Doe";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
