package com.example.a20201003_muhammadsidique_nycschools;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a20201003_muhammadsidique_nycschools.database.SatSchools;

public class DetailActivity extends AppCompatActivity {

    private static final String SAT_TEST_TAKERS = "Number of Sat Test Takers  ";
    private static final String CRITICAL_READING_AVG_SCORE ="Sat Critical Reading Avg Score  ";
    private static final String SAT_MATH_AVG_SCORE = "Sat Math Avg Score  ";
    private static final String SAT_AVG_WRITING_SCORE = "Sat Avg Writing Score ";

    private TextView tvSchoolId;
    private TextView tvNumberOfSatTestTakers;
    private TextView tvSatCriticalReadingAvgScore;
    private TextView tvSatMathAvgScore;
    private TextView tvSatWritingAvgScore;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_screen_activity);

        tvSchoolId = findViewById(R.id.tvSchoolId);
        tvNumberOfSatTestTakers = findViewById(R.id.tvNumberOfSatTestTakers);
        tvSatCriticalReadingAvgScore = findViewById(R.id.tvSatCriticalReadingAvgScore);
        tvSatMathAvgScore = findViewById(R.id.tvSatMathAvgScore);
        tvSatWritingAvgScore = findViewById(R.id.tvSatWritingAvgScore);


        SatSchools satSchools = getIntent().getParcelableExtra("SATOBJECT");

        if (satSchools != null){

            tvSchoolId.setText(satSchools.getSatId());
            tvNumberOfSatTestTakers.setText(SAT_TEST_TAKERS+satSchools.getNumberOfSatTakers());
            tvSatCriticalReadingAvgScore.setText(CRITICAL_READING_AVG_SCORE+satSchools.getSatCriticalReadingAvgScore());
            tvSatMathAvgScore.setText(SAT_MATH_AVG_SCORE+satSchools.getSatMathAvgScore());
            tvSatWritingAvgScore.setText(SAT_AVG_WRITING_SCORE+satSchools.getSatAvgWritingScore());

        }

    }
}
