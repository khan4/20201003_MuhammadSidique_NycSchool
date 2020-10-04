package com.example.a20201003_muhammadsidique_nycschools.threads;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {

    public static AppExecutor instance;

    public static AppExecutor getInstance(){

        if (instance == null){
            instance = new AppExecutor();
        }
        return instance;
    }



    private final Executor mDiskIO = Executors.newSingleThreadExecutor();
    private final Executor mMainThreadExecutor = new MainThreadExecutors();

    public Executor getmDiskIO() {
        return mDiskIO;
    }

    public Executor getmMainThreadExecutor() {
        return mMainThreadExecutor;
    }

    private static class MainThreadExecutors implements Executor{

         Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }

}
