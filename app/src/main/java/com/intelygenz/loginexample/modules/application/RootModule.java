package com.intelygenz.loginexample.modules.application;

import android.content.Context;

import com.intelygenz.loginexample.app.ExampleLoginApp;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jcminarro on 11/11/14.
 */

@Module(injects = ExampleLoginApp.class, library = true, complete = false)
public class RootModule {

    public static final String APPLICATION_CONTEXT = "ApplicationContext";

    private Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named(RootModule.APPLICATION_CONTEXT)
    Context provideApplicationContext() {
        return this.context;
    }
}
