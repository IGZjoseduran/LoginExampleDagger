package com.intelygenz.loginexample.modules.application;

import android.content.Context;

import com.intelygenz.loginexample.storage.ISPData;
import com.intelygenz.loginexample.storage.SPData;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 12/12/2014.
 */
@Module(library = true, complete = false)
public class ISPDataModule {


    @Provides
    @Singleton
    ISPData provideIData(@Named(RootModule.APPLICATION_CONTEXT) Context context) {
        return new SPData(context);
    }
}
