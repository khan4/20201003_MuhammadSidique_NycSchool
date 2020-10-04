package com.example.a20201003_muhammadsidique_nycschools;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.a20201003_muhammadsidique_nycschools.database.School;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnit4.class)
public class SchoolDaoTest extends SchoolDatabaseTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void insertReadDelete() throws Exception{


     School school = new School("123","School Name 1","1234567","Manhattan","11232");

     //inserted
     getSchoolDao().insertSchool(school);
     LiveDataTestUtil<List<School>> liveDataTestUtil = new LiveDataTestUtil<>();

     //Reteriving values from Dummy Database
     List<School> insertedSchools = liveDataTestUtil.getValue(getSchoolDao().getAllSchoolData());

     //Testing data is inserted in the database
      assertNotNull(insertedSchools);

      //Testing every property matches with the inserted Entry
      assertEquals(school.getCityName(), insertedSchools.get(0).getCityName());
      assertEquals(school.getPhoneNumber(),insertedSchools.get(0).getPhoneNumber());
      assertEquals(school.getZipCode(), insertedSchools.get(0).getZipCode());
      assertEquals(school.getSchoolName(), insertedSchools.get(0).getSchoolName());
      assertEquals(school.getPrimaryKey(), insertedSchools.get(0).getPrimaryKey());


      //delete
        getSchoolDao().deleteSchool(school);


        //Confirming deletion is sucessfull database is empty
        insertedSchools = liveDataTestUtil.getValue(getSchoolDao().getAllSchoolData());

        //Testing the database is empty this time
        assertEquals(0,insertedSchools.size());



    }

}
