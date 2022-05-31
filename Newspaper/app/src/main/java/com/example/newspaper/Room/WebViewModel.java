package com.example.newspaper.Room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WebViewModel extends AndroidViewModel {

    private WebRepository repository;
    private LiveData<List<Website>> allBookmarks;

    public WebViewModel(@NonNull Application application) {
        super(application);
        repository = new WebRepository(application);
        allBookmarks = repository.getAllBookmarks();
    }

    public void insert(Website website) {
        repository.insert(website);
    }

    public void delete(Website website) {
        repository.delete(website);
    }

    public LiveData<List<Website>> getAllBookmarks() {
        return allBookmarks;
    }
}
