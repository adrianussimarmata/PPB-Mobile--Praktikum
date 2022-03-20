package com.example.tugasku;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TugasRepository {

    private TugasDao tugasDao;
    private TugasDatabase tugas_db;
    private LiveData<List<Tugas>> listTugas;

    public TugasRepository(Application application) {
        tugas_db = TugasDatabase.getInstance(application);
        tugasDao = tugas_db.tugasDao();
        listTugas = tugasDao.getAllTugas();
    }

    public LiveData<List<Tugas>> getAllTugas() {
        return tugasDao.getAllTugas();
    }

    public void insertTugas(Tugas tugas) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                tugas_db.tugasDao().insertTugas(tugas);
                return null;
            }
        }.execute();
    }
}
