package com.example.a20201003_muhammadsidique_nycschools.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "SchoolDatabase")
public class School {


    @PrimaryKey
    @NonNull
    private String primaryKey;

    @ColumnInfo(name = "SchoolName")
    private String schoolName;

    @ColumnInfo(name = "PhoneNumber")
    private String phoneNumber;

    @ColumnInfo(name = "City")
    private String cityName;

    @ColumnInfo(name = "Zip")
    private String zipCode;



    @Ignore
    public School() {
    }

    public School(@NonNull String primaryKey, String schoolName, String phoneNumber, String cityName, String zipCode) {
        this.primaryKey = primaryKey;
        this.schoolName = schoolName;
        this.phoneNumber = phoneNumber;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    @NonNull
    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(@NonNull String primaryKey) {
        this.primaryKey = primaryKey;
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
        School school = (School) o;

//        if (primaryKey != school.primaryKey || schoolName != school.getSchoolName() || phoneNumber!= school.getPhoneNumber()
//             || cityName != school.getCityName() || zipCode != school.getZipCode() ){
//            return false;
//        }

        return primaryKey.equals(school.primaryKey) &&
                schoolName.equals(school.schoolName) &&
                phoneNumber.equals(school.phoneNumber) &&
                cityName.equals(school.cityName) &&
                zipCode.equals(school.zipCode);
    }


}
