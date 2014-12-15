package com.intelygenz.loginexample.modules.application;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 15/12/2014.
 */
@Module(library = true, complete = false)
public class MainThreadModule {


    @Provides
    @Singleton
    MainThread provideMainThread() {
        return new MainThreadImpl();
    }



    public interface MainThread {

        void post(final Runnable runnable);
    }

    public class MainThreadImpl implements MainThread {

        private final Handler handler;

        public MainThreadImpl() {
            handler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void post(Runnable runnable) {
            handler.post(runnable);
        }
    }


}


