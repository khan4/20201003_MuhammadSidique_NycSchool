package com.example.a20201003_muhammadsidique_nycschools.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;

import androidx.lifecycle.LiveData;

import com.example.a20201003_muhammadsidique_nycschools.database.SatDao;
import com.example.a20201003_muhammadsidique_nycschools.database.SatSchoolDataBase;
import com.example.a20201003_muhammadsidique_nycschools.database.SatSchools;
import com.example.a20201003_muhammadsidique_nycschools.threads.AppExecutor;

public class SatRepository {

    private SatSchoolDataBase satDataBase;
    private SatDao satDao;

    public SatRepository(Application application){
        satDataBase = SatSchoolDataBase.getInstance(application);
        satDao = satDataBase.getSatDao();
    }


    public void insertSatSchool(final SatSchools satSchools){

        AppExecutor.getInstance().getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                satDao.insertSatSchool(satSchools);
            }
        });
    }


    public LiveData<SatSchools> findSatSchool(final String id){
       LiveData<SatSchools> satSchoolsLiveData = satDao.find(id);
       return satSchoolsLiveData;
    }



}
