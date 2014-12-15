package com.intelygenz.loginexample.modules.application;

import android.content.Context;

import com.intelygenz.loginexample.net.ApiModule;
import com.intelygenz.loginexample.net.IServiceLayer;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 12/12/2014.
 */
@Module(library = true, complete = false)
public class IServiceLayerModule {


    @Provides
    @Singleton
    IServiceLayer provideServiceLayer(@Named(RootModule.APPLICATION_CONTEXT) Context context) {
        return ApiModule.getAPIaryService();
    }
}

