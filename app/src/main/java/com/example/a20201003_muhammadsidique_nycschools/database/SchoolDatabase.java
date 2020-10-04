package com.example.a20201003_muhammadsidique_nycschools.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {School.class}, version = 1,exportSchema = false)
public abstract class SchoolDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "School_Database";
    private static SchoolDatabase instance;
    private static final Object LOCK = new Object();

    public static SchoolDatabase getInstance(Context context){

        if (instance == null){

            synchronized (LOCK){

                instance = Room.databaseBuilder(context.getApplicationContext(),
                        SchoolDatabase.class,
                        DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instance;
    }


    public abstract SchoolDao getSchoolDao();


}
