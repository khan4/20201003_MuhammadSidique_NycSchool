package com.example.a20201003_muhammadsidique_nycschools.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "SatScore_DataBase")
public class SatSchools implements Parcelable {

    @PrimaryKey
    @NonNull
    private String satId;

    @ColumnInfo(name = "NumberOfSatTakers")
    private String numberOfSatTakers;

    @ColumnInfo(name = "SatCriticalReadingAvgScore")
    private String satCriticalReadingAvgScore;

    @ColumnInfo(name = "SatMathAvgScore")
    private String satMathAvgScore;

    @ColumnInfo(name = "SatWritingAvgScore")
    private String satAvgWritingScore;

    @Ignore
    public SatSchools() {
    }

    public SatSchools(@NonNull String satId, String numberOfSatTakers, String satCriticalReadingAvgScore, String satMathAvgScore, String satAvgWritingScore) {
        this.satId = satId;
        this.numberOfSatTakers = numberOfSatTakers;
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
        this.satMathAvgScore = satMathAvgScore;
        this.satAvgWritingScore = satAvgWritingScore;
    }


    @NonNull
    public String getSatId() {
        return satId;
    }

    public void setSatId(@NonNull String satId) {
        this.satId = satId;
    }

    public String getNumberOfSatTakers() {
        return numberOfSatTakers;
    }

    public void setNumberOfSatTakers(String numberOfSatTakers) {
        this.numberOfSatTakers = numberOfSatTakers;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public void setSatCriticalReadingAvgScore(String satCriticalReadingAvgScore) {
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatAvgWritingScore() {
        return satAvgWritingScore;
    }

    public void setSatAvgWritingScore(String satAvgWritingScore) {
        this.satAvgWritingScore = satAvgWritingScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(satId);
        dest.writeString(numberOfSatTakers);
        dest.writeString(satCriticalReadingAvgScore);
        dest.writeString(satMathAvgScore);
        dest.writeString(satAvgWritingScore);
    }

    protected SatSchools(Parcel in) {
        satId = in.readString();
        numberOfSatTakers = in.readString();
        satCriticalReadingAvgScore = in.readString();
        satMathAvgScore = in.readString();
        satAvgWritingScore = in.readString();
    }

    public static final Creator<SatSchools> CREATOR = new Creator<SatSchools>() {
        @Override
        public SatSchools createFromParcel(Parcel in) {
            return new SatSchools(in);
        }

        @Override
        public SatSchools[] newArray(int size) {
            return new SatSchools[size];
        }
    };
}
