package com.example.tugasku;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();
    private static TaskDatabase INSTANCE;

    public static synchronized TaskDatabase getInstance(Context context) {
        if(INSTANCE == null) {
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, "task_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private TaskDao taskDao;

        private PopulateDbAsyncTask(TaskDatabase db) {
            taskDao = db.taskDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            taskDao.insert(new Task("Title 1", "01-01-2022", "31-12-2022", "Description Task 1"));
            taskDao.insert(new Task("Title 2", "02-01-2022", "31-12-2022", "Description Task 2"));
            taskDao.insert(new Task("Title 3", "03-01-2022", "31-12-2022", "Description Task 3"));

            return null;
        }
    }
}
