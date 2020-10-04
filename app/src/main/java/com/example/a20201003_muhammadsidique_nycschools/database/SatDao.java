package com.example.a20201003_muhammadsidique_nycschools.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SatDao {


    @Insert(onConflict = REPLACE)
    void insertSatSchool(SatSchools satSchools);


    @Query("SELECT * FROM SatScore_DataBase WHERE satId = :id")
    LiveData<SatSchools> find(String id);

    @Query("SELECT * FROM SatScore_DataBase")
    LiveData<List<SatSchools>> getAllSatSchools();

    @Delete
    void deleteSatSchoolData(SatSchools satSchools);

}
