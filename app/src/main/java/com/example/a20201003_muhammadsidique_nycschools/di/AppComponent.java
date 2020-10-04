package com.example.a20201003_muhammadsidique_nycschools.di;


import android.app.Application;

import com.example.a20201003_muhammadsidique_nycschools.BaseApplication;
import com.example.a20201003_muhammadsidique_nycschools.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class

        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {



    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
