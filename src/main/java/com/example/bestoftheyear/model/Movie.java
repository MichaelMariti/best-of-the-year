package com.example.bestoftheyear.model;

public class Movie {
    private Integer id;
    private String title;

    // Costruttore
    public Movie(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getter
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
