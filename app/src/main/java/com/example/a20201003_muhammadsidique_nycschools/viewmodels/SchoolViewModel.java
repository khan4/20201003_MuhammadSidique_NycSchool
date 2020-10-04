package com.example.a20201003_muhammadsidique_nycschools.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20201003_muhammadsidique_nycschools.model.HighSchool;
import com.example.a20201003_muhammadsidique_nycschools.model.SatModel;
import com.example.a20201003_muhammadsidique_nycschools.model.SchoolApi;
import com.example.a20201003_muhammadsidique_nycschools.repositories.Repository;
import com.example.a20201003_muhammadsidique_nycschools.resource.Resource;

import java.util.List;

import javax.inject.Inject;


public class SchoolViewModel extends ViewModel {


    private Repository repository;

    @Inject
    public SchoolViewModel(SchoolApi schoolApi){
       repository = new Repository(schoolApi);
    }


    public LiveData<Resource<List<HighSchool>>> getSchoolData(){
        return repository.getHighSchoolData();
    }

    public LiveData<Resource<List<SatModel>>> getSatSchoolData(){
        return repository.getSatSchoolsScore();
    }


}
