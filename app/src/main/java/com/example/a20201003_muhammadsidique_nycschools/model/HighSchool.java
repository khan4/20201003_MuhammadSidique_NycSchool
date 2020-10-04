package com.example.a20201003_muhammadsidique_nycschools.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class HighSchool {

    @SerializedName("dbn")
    @Expose
    private String schoolId;

    @SerializedName("school_name")
    @Expose
    private String schoolName;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("city")
    @Expose
    private String cityName;

    @SerializedName("zip")
    @Expose
    private String zipCode;


    private int chechId;


    public int getChechId() {
        return chechId;
    }

    public void setChechId(int chechId) {
        this.chechId = chechId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighSchool school = (HighSchool) o;
        return chechId == school.chechId;
    }


}
