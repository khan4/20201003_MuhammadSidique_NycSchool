package com.example.a20201003_muhammadsidique_nycschools;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.a20201003_muhammadsidique_nycschools.database.SatSchools;
import com.example.a20201003_muhammadsidique_nycschools.database.School;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SatDaoTest extends SatDatabaseTest {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void insertTest() throws Exception{

        SatSchools satSchools = new SatSchools("123","56","12","66","89");

        //Inserting data in dummy database
        getSatDao().insertSatSchool(satSchools);

        LiveDataTestUtil<List<SatSchools>> listLiveDataTestUtil = new LiveDataTestUtil<>();
        LiveDataTestUtil<SatSchools> sss = new LiveDataTestUtil<>();

        //Reteriving values from Dummy Database
        List<SatSchools> insertedSchools = listLiveDataTestUtil.getValue(getSatDao().getAllSatSchools());

        //Testing Data is inserted Sucessfully
        assertNotNull(insertedSchools);

        //Testing Every Entry Matching with the inserted Data
        assertEquals(satSchools.getSatId(),insertedSchools.get(0).getSatId());
        assertEquals(satSchools.getNumberOfSatTakers(),insertedSchools.get(0).getNumberOfSatTakers());
        assertEquals(satSchools.getSatAvgWritingScore(),insertedSchools.get(0).getSatAvgWritingScore());
        assertEquals(satSchools.getSatCriticalReadingAvgScore(),insertedSchools.get(0).getSatCriticalReadingAvgScore());
        assertEquals(satSchools.getSatMathAvgScore(),insertedSchools.get(0).getSatMathAvgScore());


        //Passing the id of the inserted Data and Finding it
         SatSchools satSchool = sss.getValue(getSatDao().find("123"));

         //Comparing Two Objects Primary Keys Which Varifies that both objects are same are equals
         assertEquals(satSchool.getSatId(),satSchools.getSatId());


    }

}
