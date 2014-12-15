package com.intelygenz.loginexample.modules.login;

import android.content.Context;

import com.intelygenz.loginexample.storage.ISPData;
import com.intelygenz.loginexample.storage.SPData;
import com.intelygenz.loginexample.utils.ILoginChecker;
import com.intelygenz.loginexample.utils.ServerLoginChecker;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 12/12/2014.
 */
@Module(library = true, complete = false)
public class ILoginCheckerModule {

    
    @Provides
    @Singleton
    ILoginChecker provideLoginChecker(){
        return new ServerLoginChecker();
    }
}
