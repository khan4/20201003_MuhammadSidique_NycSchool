package com.example.a20201003_muhammadsidique_nycschools.di;

import com.example.a20201003_muhammadsidique_nycschools.MainActivity;
import com.example.a20201003_muhammadsidique_nycschools.module.AppModule;
import com.example.a20201003_muhammadsidique_nycschools.module.SchoolApiModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {


    @ContributesAndroidInjector(
       modules = {SchoolViewModelModules.class, SchoolApiModule.class}
    )
    abstract MainActivity contributeMainActivity();


}
