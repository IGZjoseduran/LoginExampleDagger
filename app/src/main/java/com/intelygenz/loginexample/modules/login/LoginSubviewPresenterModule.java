package com.intelygenz.loginexample.modules.login;

import com.intelygenz.loginexample.modules.application.MainThreadModule;
import com.intelygenz.loginexample.net.IServiceLayer;
import com.intelygenz.loginexample.presenters.LoginPresenter;
import com.intelygenz.loginexample.presenters.LoginSubviewPresenter;
import com.intelygenz.loginexample.screens.activities.LoginActivity;
import com.intelygenz.loginexample.screens.fragments.LoginFragment;
import com.intelygenz.loginexample.storage.ISPData;
import com.intelygenz.loginexample.utils.ILoginChecker;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 12/12/2014.
 */

@Module(library = true, complete = false, injects = {LoginFragment.class})
public class LoginSubviewPresenterModule {

    @Provides
    @Singleton
    LoginSubviewPresenter provideLoginSubviewPresenter(LoginPresenter loginPresenter) {
        return new LoginSubviewPresenter(loginPresenter);
    }




}
