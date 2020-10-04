package com.example.a20201003_muhammadsidique_nycschools.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.a20201003_muhammadsidique_nycschools.model.HighSchool;
import com.example.a20201003_muhammadsidique_nycschools.model.SatModel;
import com.example.a20201003_muhammadsidique_nycschools.model.SchoolApi;
import com.example.a20201003_muhammadsidique_nycschools.resource.Resource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DataSource {

    private SchoolApi schoolApi;

    private MediatorLiveData<Resource<List<HighSchool>>> mediatorLiveData;
    private MediatorLiveData<Resource<List<SatModel>>> satMediatorLiveData;

    public DataSource(SchoolApi schoolApi){
        this.schoolApi = schoolApi;
    }


    public LiveData<Resource<List<HighSchool>>> observeSchoolList(){

        if (mediatorLiveData == null){

            mediatorLiveData = new MediatorLiveData<>();

            mediatorLiveData.setValue(Resource.loading((List<HighSchool>)null));

            final LiveData<Resource<List<HighSchool>>> source = LiveDataReactiveStreams.fromPublisher(


                    schoolApi.getHighSchoolList()
                    .onErrorReturn(new Function<Throwable, List<HighSchool>>() {
                        @Override
                        public List<HighSchool> apply(Throwable throwable) throws Exception {

                            HighSchool highSchool = new HighSchool();
                            highSchool.setChechId(-1);
                            ArrayList<HighSchool> list = new ArrayList<>();
                            list.add(highSchool);

                            return list;
                        }
                    })

                    .map(new Function<List<HighSchool>, Resource<List<HighSchool>>>() {
                        @Override
                        public Resource<List<HighSchool>> apply(List<HighSchool> highSchools) throws Exception {
                            if (highSchools!=null && highSchools.size()>0){

                                HighSchool school = highSchools.get(0);

                                if (school.getChechId() == -1){
                                    return Resource.error("Some Thing Went Wrong ",null);
                                }

                            }
                            return Resource.success(highSchools);
                        }
                    })
                    .subscribeOn(Schedulers.io())

            );


            mediatorLiveData.addSource(source, new Observer<Resource<List<HighSchool>>>() {
                @Override
                public void onChanged(Resource<List<HighSchool>> listResource) {

                    mediatorLiveData.setValue(listResource);
                    mediatorLiveData.removeSource(source);
                }
            });

        }

        return mediatorLiveData;

    }

    public LiveData<Resource<List<SatModel>>> getSatScoreSchool(){

        if (satMediatorLiveData == null){

            satMediatorLiveData = new MediatorLiveData<>();

            satMediatorLiveData.setValue(Resource.loading((List<SatModel>)null));

            final LiveData<Resource<List<SatModel>>> source = LiveDataReactiveStreams.fromPublisher(

                    schoolApi.getSchoolsSatScore()
                    .onErrorReturn(new Function<Throwable, List<SatModel>>() {
                        @Override
                        public List<SatModel> apply(Throwable throwable) throws Exception {

                            //If error occurs we will set the id to -1
                            //So that we can check when mapping the result
                            SatModel satModel = new SatModel();
                            satModel.setCheckId(-1);

                            ArrayList<SatModel> list = new ArrayList<>();
                            list.add(satModel);
                            return list;
                        }
                    })
                    .map(new Function<List<SatModel>, Resource<List<SatModel>>>() {
                        @Override
                        public Resource<List<SatModel>> apply(List<SatModel> satList) throws Exception {

                            if (satList.size()>0 && satList!=null){

                                SatModel satModel = satList.get(0);

                                //To check if any error occured during accessing Api
                                if (satModel.getCheckId() == -1){
                                    return Resource.error("Some thing went wrong", null);
                                }

                            }

                            return Resource.success(satList);
                        }
                    })
                    .subscribeOn(Schedulers.io())

            );


            satMediatorLiveData.addSource(source, new Observer<Resource<List<SatModel>>>() {
                @Override
                public void onChanged(Resource<List<SatModel>> listResource) {

                    satMediatorLiveData.setValue(listResource);
                    satMediatorLiveData.removeSource(source);
                }
            });

        }

        return satMediatorLiveData;

    }



}
