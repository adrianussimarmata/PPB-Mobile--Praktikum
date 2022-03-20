package com.example.tugasku;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TugasViewModel extends AndroidViewModel {

    TugasRepository tugasRepository;
    LiveData<List<Tugas>> listTugas;

    public TugasViewModel(@NonNull Application application) {
        super(application);
        tugasRepository = new TugasRepository(application);
        listTugas = tugasRepository.getAllTugas();
    }

    public LiveData<List<Tugas>> getAllTugas() {
        return tugasRepository.getAllTugas();
    }

    public void insertTugas(Tugas tugas) {
        tugasRepository.insertTugas(tugas);
    }
}
