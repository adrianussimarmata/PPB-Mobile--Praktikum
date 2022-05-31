package com.example.newspaper.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "web_table")
public class Website {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    private String title;
    private String url_image;

    public Website(String url, String title, String url_image) {
        this.url = url;
        this.title = title;
        this.url_image = url_image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl_image() {
        return url_image;
    }
}
