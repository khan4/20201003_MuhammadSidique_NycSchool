package com.example.a20201003_muhammadsidique_nycschools;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.a20201003_muhammadsidique_nycschools.database.SchoolDao;
import com.example.a20201003_muhammadsidique_nycschools.database.SchoolDatabase;

import org.junit.After;
import org.junit.Before;

public abstract class SchoolDatabaseTest {

    private SchoolDatabase schoolDatabase;


    public SchoolDao getSchoolDao(){
        return schoolDatabase.getSchoolDao();
    }

    @Before
    public void init(){
        schoolDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                SchoolDatabase.class
        ).build();
    }

    @After
    public void finish(){
        schoolDatabase.close();
    }


}
