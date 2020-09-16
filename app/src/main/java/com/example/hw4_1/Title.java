package com.example.hw4_1;

public class Title {
    String title;
    String description;

    public Title(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Title() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
