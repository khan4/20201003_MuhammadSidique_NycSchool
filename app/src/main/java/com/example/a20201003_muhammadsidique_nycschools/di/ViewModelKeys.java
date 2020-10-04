package com.example.a20201003_muhammadsidique_nycschools.di;


import androidx.lifecycle.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKeys {

    Class<? extends ViewModel> value();

}
