package com.example.tugasku;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tugas.class}, version = 1, exportSchema = false)
public abstract class TugasDatabase extends RoomDatabase {

    public abstract TugasDao tugasDao();
    public static volatile TugasDatabase INSTANCE;

    static TugasDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TugasDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, TugasDatabase.class, "tugas.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
