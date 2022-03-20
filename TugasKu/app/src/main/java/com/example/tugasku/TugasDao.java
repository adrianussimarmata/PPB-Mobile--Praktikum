package com.example.tugasku;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TugasDao {

    @Insert
    void insertTugas(Tugas tugas);

    @Query("SELECT * FROM tbl_tugas")
    LiveData<List<Tugas>> getAllTugas();
}
