package com.example.tugasku;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String deadline;
    private String note;
    private String create_date;

    public Task(String title, String deadline, String note, String create_date) {
        this.title = title;
        this.deadline = deadline;
        this.note = note;
        this.create_date = create_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getNote() {
        return note;
    }

    public String getCreate_date() {
        return create_date;
    }
}
