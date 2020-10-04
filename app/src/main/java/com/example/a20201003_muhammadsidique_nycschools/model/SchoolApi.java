package com.example.a20201003_muhammadsidique_nycschools.model;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface SchoolApi {

     @GET("s3k6-pzi2.json")
     Flowable<List<HighSchool>> getHighSchoolList();

     @GET("f9bf-2cp4.json")
     Flowable<List<SatModel>> getSchoolsSatScore();



}
