package com.example.tugasku;

import androidx.room.Entity;
import androidx.room.PrimaryKey;;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String deadline;

    private String note;

    private String create_date;

    public Task(String title, String create_date, String deadline, String note) {
        this.title = title;
        this.create_date = create_date;
        this.deadline = deadline;
        this.note = note;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
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
