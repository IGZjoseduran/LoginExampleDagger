package com.intelygenz.loginexample.app;

import android.app.Application;

import com.intelygenz.loginexample.modules.application.ISPDataModule;
import com.intelygenz.loginexample.modules.application.IServiceLayerModule;
import com.intelygenz.loginexample.modules.application.MainThreadModule;
import com.intelygenz.loginexample.modules.application.RootModule;

import dagger.ObjectGraph;

/**
 * Created by jose.duran on 12/12/2014.
 */
public class ExampleLoginApp extends Application {
    private ObjectGraph objectGraph;


    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules());
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }


    public ObjectGraph plusModules(Object... modules) {
        return objectGraph.plus(modules);
    }

    private Object[] getModules() {
        return new Object[]{new RootModule(this), new ISPDataModule(), new IServiceLayerModule(), new MainThreadModule()};
    }

}
