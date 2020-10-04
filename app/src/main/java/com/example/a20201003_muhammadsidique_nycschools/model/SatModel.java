package com.example.a20201003_muhammadsidique_nycschools.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SatModel {

    @SerializedName("dbn")
    @Expose
    private String satSchoolId;

    @SerializedName("num_of_sat_test_takers")
    @Expose
    private String numberOfSatTakers;

    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    private String staCriticalReadingAvgScore;

    @SerializedName("sat_math_avg_score")
    @Expose
    private String satMathAvgScore;

    @SerializedName("sat_writing_avg_score")
    @Expose
    private String satWritingAvgScore;


    private int checkId;

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public String getSatSchoolId() {
        return satSchoolId;
    }

    public void setSatSchoolId(String satSchoolId) {
        this.satSchoolId = satSchoolId;
    }

    public String getNumberOfSatTakers() {
        return numberOfSatTakers;
    }

    public void setNumberOfSatTakers(String numberOfSatTakers) {
        this.numberOfSatTakers = numberOfSatTakers;
    }

    public String getStaCriticalReadingAvgScore() {
        return staCriticalReadingAvgScore;
    }

    public void setStaCriticalReadingAvgScore(String staCriticalReadingAvgScore) {
        this.staCriticalReadingAvgScore = staCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }
}
