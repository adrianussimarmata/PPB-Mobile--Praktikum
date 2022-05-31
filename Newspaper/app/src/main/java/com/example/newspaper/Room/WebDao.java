package com.example.newspaper.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WebDao {

    @Insert
    void insert(Website website);

    @Delete
    void delete(Website website);

    @Query("DELETE FROM web_table")
    void deleteAllBookmarks();

    @Query("SELECT * FROM web_table ORDER BY id DESC")
    LiveData<List<Website>> getAllBookmarks();
}
