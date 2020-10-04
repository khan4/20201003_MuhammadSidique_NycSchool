package com.example.a20201003_muhammadsidique_nycschools;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.a20201003_muhammadsidique_nycschools.database.SatDao;
import com.example.a20201003_muhammadsidique_nycschools.database.SatSchoolDataBase;
import com.example.a20201003_muhammadsidique_nycschools.database.SchoolDatabase;

import org.junit.After;
import org.junit.Before;

public abstract class SatDatabaseTest {


    private SatSchoolDataBase satSchoolDataBase;

    public SatDao getSatDao(){
        return satSchoolDataBase.getSatDao();
    }

    //Initilizing the dummy database for testing
    @Before
    public void init(){
        satSchoolDataBase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                SatSchoolDataBase.class
        ).build();
    }

    //Closing the database After testing
    @After
    public void finish(){
        satSchoolDataBase.close();
    }

}
