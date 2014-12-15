package com.intelygenz.loginexample.presenters;

import com.intelygenz.loginexample.screens.fragments.LoginFragment;

/**
 * Created by jose.duran on 15/12/2014.
 */
public class LoginSubviewPresenter {

    private LoginPresenter mLoginPresenter;
    private LoginSubviewScreen loginSubviewScreen;

    public LoginSubviewPresenter(LoginPresenter loginPresenter){
        mLoginPresenter = loginPresenter;
    }


    public void clickOnLogin(String user, String password) {
       mLoginPresenter.clickOnLogin(user, password);
    }

    public void setScreen(LoginSubviewScreen loginSubviewScreen) {

        this.loginSubviewScreen = loginSubviewScreen;
    }

    public void clickOnNewUser() {
        mLoginPresenter.showRegisterScreen();
    }


    public interface LoginSubviewScreen {

    }
}
