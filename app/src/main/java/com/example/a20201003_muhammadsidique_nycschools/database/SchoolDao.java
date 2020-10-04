package com.example.a20201003_muhammadsidique_nycschools.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SchoolDao {


    @Insert(onConflict = IGNORE)
    long[] detectingSchoolConflict(School... schools);

    @Insert(onConflict = REPLACE)
    void insertSchool(School school);


    @Query("SELECT * FROM SchoolDatabase")
    LiveData<List<School>> getAllSchoolData();

    @Delete
    void deleteSchool(School school) throws Exception;

}
