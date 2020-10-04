package com.example.a20201003_muhammadsidique_nycschools.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelProviderFactory providerFactory);

}
