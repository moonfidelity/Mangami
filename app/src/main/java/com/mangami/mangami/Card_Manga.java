package com.mangami.mangami;

public class Card_Manga {
    private String title;
    private String category;
    private String author;
    private String description;
    private int thumbnail;

    public Card_Manga() {
    }

    public Card_Manga(String title, String category, String author, int thumbnail, String description) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }
}