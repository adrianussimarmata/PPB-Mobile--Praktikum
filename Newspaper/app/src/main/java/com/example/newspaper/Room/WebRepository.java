package com.example.newspaper.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WebRepository {

    private WebDao webDao;
    private LiveData<List<Website>> allBookmarks;

    public WebRepository(Application application) {
        WebDatabase database = WebDatabase.getInstance(application);
        webDao = database.webDao();
        allBookmarks = webDao.getAllBookmarks();
    }

    public void insert(Website website) {
        new InsertWebAsyncTask(webDao).execute(website);
    }

    public void delete(Website website) {
        new DeleteWebAsyncTask(webDao).execute(website);
    }

    public LiveData<List<Website>> getAllBookmarks() {
        return allBookmarks;
    }

    private static class InsertWebAsyncTask extends AsyncTask<Website, Void, Void> {
        private WebDao webDao;

        private InsertWebAsyncTask(WebDao webDao) {
            this.webDao = webDao;
        }

        @Override
        protected Void doInBackground(Website... websites) {
            webDao.insert(websites[0]);
            return null;
        }
    }

    private static class DeleteWebAsyncTask extends AsyncTask<Website, Void, Void> {
        private WebDao webDao;

        private DeleteWebAsyncTask(WebDao webDao) {
            this.webDao = webDao;
        }

        @Override
        protected Void doInBackground(Website... websites) {
            webDao.delete(websites[0]);
            return null;
        }
    }
}
