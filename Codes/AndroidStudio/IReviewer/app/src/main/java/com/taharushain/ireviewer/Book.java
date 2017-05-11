package com.taharushain.ireviewer;

/**
 * Created by taharushain on 5/11/17.
 */

public class Book {

    private int id, reviewer_id;
    private String name, author;

    public Book() {

    }


    public Book(int id, int reviewer_id, String name, String author) {
        this.id = id;
        this.reviewer_id = reviewer_id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(int reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
