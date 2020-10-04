package com.example.a20201003_muhammadsidique_nycschools.module;

import com.example.a20201003_muhammadsidique_nycschools.model.HighSchool;
import com.example.a20201003_muhammadsidique_nycschools.model.SchoolApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class SchoolApiModule {


    @Provides
    static SchoolApi providesSchoolApi(Retrofit retrofit){
        return retrofit.create(SchoolApi.class);
    }

}
