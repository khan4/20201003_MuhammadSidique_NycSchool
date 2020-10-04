package com.example.a20201003_muhammadsidique_nycschools.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.a20201003_muhammadsidique_nycschools.database.School;
import com.example.a20201003_muhammadsidique_nycschools.repositories.HighSchoolRepository;

import java.util.List;

public class HighSchoolViewModel extends AndroidViewModel {


    private HighSchoolRepository repository;

    public HighSchoolViewModel(@NonNull Application application) {
        super(application);
        repository = new HighSchoolRepository(application);
    }


    public void insertSchoolInfo(School school){
        repository.insertSchoolInfo(school);
    }

    public LiveData<List<School>> getSchoolsData(){
        return repository.getAllSchoolsInfo();
    }

    public long[] detectingSchoolConflict(School school){
        return repository.detectingSchoolConflict(school);
    }

}
