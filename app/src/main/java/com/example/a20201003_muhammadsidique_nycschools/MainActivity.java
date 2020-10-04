package com.example.a20201003_muhammadsidique_nycschools;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.AvailableNetworkInfo;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.a20201003_muhammadsidique_nycschools.database.SatSchools;
import com.example.a20201003_muhammadsidique_nycschools.database.School;
import com.example.a20201003_muhammadsidique_nycschools.di.ViewModelProviderFactory;
import com.example.a20201003_muhammadsidique_nycschools.model.HighSchool;
import com.example.a20201003_muhammadsidique_nycschools.model.SatModel;
import com.example.a20201003_muhammadsidique_nycschools.recyclerview.RecyclerViewAdapter;
import com.example.a20201003_muhammadsidique_nycschools.resource.Resource;
import com.example.a20201003_muhammadsidique_nycschools.viewmodels.HighSchoolViewModel;
import com.example.a20201003_muhammadsidique_nycschools.viewmodels.SatViewModel;
import com.example.a20201003_muhammadsidique_nycschools.viewmodels.SchoolViewModel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements RecyclerViewAdapter.onClickListener{
    private static final String TAG = "MainActivity";

    @Inject
    ViewModelProviderFactory factory;

    @Inject
    RecyclerViewAdapter adapter;

    private List<School> schoolInfoList;


    private SchoolViewModel schoolViewModel;
    private HighSchoolViewModel highSchoolViewModel;
    private SatViewModel satViewModel;


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        schoolViewModel = ViewModelProviders.of(this,factory).get(SchoolViewModel.class);
        highSchoolViewModel = ViewModelProviders.of(this).get(HighSchoolViewModel.class);
        satViewModel = ViewModelProviders.of(this).get(SatViewModel.class);





      getData();
      observeDatabase();

    }

    private void getData(){


        schoolViewModel.getSchoolData().observe(this, new Observer<Resource<List<HighSchool>>>() {
            @Override
            public void onChanged(Resource<List<HighSchool>> listResource) {

                //Three Cases from our Api
                //Sucess
                //Error
                //Loading
                switch (listResource.status){
                    case LOADING:
                        break;
                    case SUCCESS:
                        putSchoolDataInDB(listResource.data);
                        break;
                    case ERROR:
                        Log.d(TAG, "onChanged: There is error ");
                        break;
                }

            }
        });

        schoolViewModel.getSatSchoolData().observe(this, new Observer<Resource<List<SatModel>>>() {
            @Override
            public void onChanged(Resource<List<SatModel>> listResource) {

                switch (listResource.status){
                    case LOADING:
                        Log.d(TAG, "onChanged: Data is Loading ");
                        break;
                    case SUCCESS:
                        putSatDataInDB(listResource.data);
                        break;
                    case ERROR:
                        Log.d(TAG, "onChanged: There is Some Error ");
                        break;
                }

            }
        });

    }

    private void putSchoolDataInDB(List<HighSchool> highSchoolsList){
        for (HighSchool highSchool : highSchoolsList){
            School school = new School(highSchool.getSchoolId(),highSchool.getSchoolName(),highSchool.getPhoneNumber(),highSchool.getCityName(),highSchool.getZipCode());
            highSchoolViewModel.insertSchoolInfo(school);

        }

    }

    private void putSatDataInDB(List<SatModel> satModelList){

        for (SatModel satModel : satModelList){

            SatSchools satSchools = new SatSchools(satModel.getSatSchoolId(),satModel.getNumberOfSatTakers(),satModel.getStaCriticalReadingAvgScore(),
                    satModel.getSatMathAvgScore(),satModel.getSatWritingAvgScore());
            satViewModel.insertSatSchool(satSchools);
        }

    }

    private void observeDatabase(){

         highSchoolViewModel.getSchoolsData().observe(this, new Observer<List<School>>() {
            @Override
            public void onChanged(List<School> schoolList) {
                schoolInfoList = schoolList;

                //For the first time when user is not connected to the internet
                //Database has zero entries
                //We must assure that we have some data in the database
                if (schoolInfoList.size() >0) {

                    //Submitting Data to the recyclerView
                    showRecyclerView(schoolInfoList);
                }
            }
        });

    }

    private void showRecyclerView(List<School> schoolList){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.submitList(schoolList,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void clickListener(int position) {
        School school = schoolInfoList.get(position);
        satViewModel.findSatSchool(school.getPrimaryKey()).observe(this, new Observer<SatSchools>() {
            @Override
            public void onChanged(SatSchools satSchools) {
                if (satSchools !=null){
                    sendResultToNewActivity(satSchools);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Important Message");
                    builder.setMessage("This School Information is not avalible on Api");

                    builder.setNegativeButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

    }

    private void sendResultToNewActivity(SatSchools satSchools){

        //Launching a new Activity and passing the result to new Activity
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("SATOBJECT",satSchools);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        MenuItem item = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;

    }


}
