package com.intelygenz.loginexample.modules.login;

import com.intelygenz.loginexample.presenters.LoginPresenter;
import com.intelygenz.loginexample.presenters.LoginSubviewPresenter;
import com.intelygenz.loginexample.presenters.RegisterPresenter;
import com.intelygenz.loginexample.screens.fragments.LoginFragment;
import com.intelygenz.loginexample.screens.fragments.RegisterFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jose.duran on 12/12/2014.
 */

@Module(library = true, complete = false, injects = {RegisterFragment.class})
public class RegisterPresenterModule {

    @Provides
    @Singleton
    RegisterPresenter provideRegisterPresenter(LoginPresenter loginPresenter) {
        return new RegisterPresenter(loginPresenter);
    }




}
