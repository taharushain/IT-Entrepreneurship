package com.example.androidwarmup;

import android.graphics.drawable.Drawable;

/**
 * Created by taharushain on 3/7/17.
 */

public class Employee {

    private static int count = 0;
    private int id;
    private String batch;
    private String fatherName;
    private String contact;
    private String name;
    private char gender;
    private int age;
    private Drawable image;

    public Employee() {
        count++;
        id = -1;
        batch = "Fall 16";
        fatherName = "Pitashiri";
        contact = "090078601";
        name = "Gaya";
        gender = '?';
        age = 1;
    }

    public Employee(int id, String batch,
                    String fatherName,
                    String contact, String name, char gender, int age, Drawable image) {
        this.id = id;
        this.batch = batch;
        this.fatherName = fatherName;
        this.contact = contact;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.image = image;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String toString(){
        return name;
    }
}
