package com.example.a20201003_muhammadsidique_nycschools.repositories;


import androidx.lifecycle.LiveData;

import com.example.a20201003_muhammadsidique_nycschools.model.HighSchool;
import com.example.a20201003_muhammadsidique_nycschools.model.SatModel;
import com.example.a20201003_muhammadsidique_nycschools.model.SchoolApi;
import com.example.a20201003_muhammadsidique_nycschools.resource.Resource;
import com.example.a20201003_muhammadsidique_nycschools.viewmodels.DataSource;

import java.util.List;

public class Repository {
    private DataSource dataSource;
    private SchoolApi schoolApi;

    public Repository(SchoolApi schoolApi) {
        this.schoolApi = schoolApi;
        dataSource = new DataSource(schoolApi);
    }

    public LiveData<Resource<List<HighSchool>>> getHighSchoolData(){
       return dataSource.observeSchoolList();
    }

    public LiveData<Resource<List<SatModel>>> getSatSchoolsScore(){
        return dataSource.getSatScoreSchool();
    }


}
