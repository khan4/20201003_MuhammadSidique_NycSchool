package com.example.a20201003_muhammadsidique_nycschools.repositories;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.a20201003_muhammadsidique_nycschools.database.School;
import com.example.a20201003_muhammadsidique_nycschools.database.SchoolDao;
import com.example.a20201003_muhammadsidique_nycschools.database.SchoolDatabase;
import com.example.a20201003_muhammadsidique_nycschools.threads.AppExecutor;

import java.util.List;


public class HighSchoolRepository {

    private SchoolDatabase schoolDatabase;
    private SchoolDao schoolDao;

    public HighSchoolRepository(Application application){
        schoolDatabase = SchoolDatabase.getInstance(application);
        schoolDao = schoolDatabase.getSchoolDao();
    }

    public void insertSchoolInfo(final School school){

        AppExecutor.getInstance().getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                schoolDao.insertSchool(school);
            }
        });

    }

    public LiveData<List<School>> getAllSchoolsInfo(){
        return schoolDao.getAllSchoolData();
    }

    public long[] detectingSchoolConflict(School school){
        return schoolDao.detectingSchoolConflict(school);
    }

}
