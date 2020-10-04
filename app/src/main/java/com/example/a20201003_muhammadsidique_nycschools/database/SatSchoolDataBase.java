package com.example.a20201003_muhammadsidique_nycschools.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SatSchools.class},version = 1,exportSchema = false)
public abstract class SatSchoolDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "SatSchool_DataBase";
    private static SatSchoolDataBase instance;
    private static final Object LOCK =  new Object();


    public static SatSchoolDataBase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SatSchoolDataBase.class,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }


    public  abstract SatDao getSatDao();

}
