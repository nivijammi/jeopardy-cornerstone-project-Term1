package com.kenzie.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    @JsonProperty("canon")
    private boolean canon;
    @JsonProperty("title")
    private String title;
    @JsonProperty("id")
    private int id;

    public boolean getCanon() {
        return canon;
    }

    public void setCanon(boolean canon) {
        this.canon = canon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
