package com.example.listviewdemo;

import android.graphics.drawable.Drawable;

/**
 * Created by taharushain on 3/6/17.
 */

public class StudentItem {

    private String name;
    private double gpa;
    private String fatherName;
    private Drawable studentImage;




    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }




    public StudentItem(String name, double gpa, String fatherName, Drawable studentImage) {
        this.name = name;
        this.gpa = gpa;
        this.fatherName = fatherName;
        this.studentImage = studentImage;
    }

    public StudentItem() {
        name=  "John Doe";
        gpa = 3.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Drawable getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(Drawable studentImage) {
        this.studentImage = studentImage;
    }
}
