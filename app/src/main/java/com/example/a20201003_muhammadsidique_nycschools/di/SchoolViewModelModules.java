package com.example.a20201003_muhammadsidique_nycschools.di;

import androidx.lifecycle.ViewModel;

import com.example.a20201003_muhammadsidique_nycschools.viewmodels.SchoolViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class SchoolViewModelModules {


    @Binds
    @IntoMap
    @ViewModelKeys(SchoolViewModel.class)
    public abstract ViewModel bindSchoolViewModel(SchoolViewModel viewModel);

}
