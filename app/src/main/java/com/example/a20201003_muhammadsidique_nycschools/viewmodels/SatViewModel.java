package com.example.a20201003_muhammadsidique_nycschools.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.a20201003_muhammadsidique_nycschools.database.SatSchools;
import com.example.a20201003_muhammadsidique_nycschools.repositories.SatRepository;

public class SatViewModel extends AndroidViewModel {

    private SatRepository satRepository;

    public SatViewModel(@NonNull Application application) {
        super(application);
        satRepository = new SatRepository(application);
    }


    public void insertSatSchool(SatSchools satSchools){
        satRepository.insertSatSchool(satSchools);
    }

    public LiveData<SatSchools> findSatSchool(String id){
        return satRepository.findSatSchool(id);
    }


}
