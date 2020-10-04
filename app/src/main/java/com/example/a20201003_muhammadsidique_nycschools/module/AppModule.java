package com.example.a20201003_muhammadsidique_nycschools.module;

import android.app.Application;

import com.example.a20201003_muhammadsidique_nycschools.model.Constants;
import com.example.a20201003_muhammadsidique_nycschools.recyclerview.RecyclerViewAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {


    @Singleton
    @Provides
    static Retrofit buildRetrofit(){
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Singleton
    @Provides
    static RecyclerViewAdapter buildRecyclerAdapter(Application application){
        return new RecyclerViewAdapter();
    }

}
