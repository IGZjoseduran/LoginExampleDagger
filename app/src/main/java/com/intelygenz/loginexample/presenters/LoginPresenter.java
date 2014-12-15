package com.intelygenz.loginexample.presenters;

import com.intelygenz.loginexample.model.Token;
import com.intelygenz.loginexample.modules.application.MainThreadModule;
import com.intelygenz.loginexample.net.IServiceLayer;
import com.intelygenz.loginexample.storage.ISPData;
import com.intelygenz.loginexample.utils.ILoginChecker;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jose.duran on 12/12/2014.
 */
public class LoginPresenter {

    private LoginScreen loginScreen;
    private IServiceLayer serviceLayer;
    private ISPData spData;
    private ILoginChecker loginChecker;
    private MainThreadModule.MainThread mainThread;

    public LoginPresenter(IServiceLayer serviceLayer, ISPData spData, ILoginChecker loginChecker, MainThreadModule.MainThread mainThread) {
        this.serviceLayer = serviceLayer;
        this.spData = spData;
        this.loginChecker = loginChecker;
    }

    public void setScreen(LoginScreen loginScreen) {
        if (loginScreen == null) {
            throw new IllegalArgumentException("You can't set a null view");
        }
        this.loginScreen = loginScreen;
    }

    public void clickOnLogin(String user, String password) {
        if (!loginChecker.isValidUser(user)) {
            loginScreen.showError("Not Valid User");
        } else if (!loginChecker.isValidPassword(password)) {
            loginScreen.showError("Not Valid Password");
        } else {
            serviceLayer.login(user, password, new Callback<Token>() {
                @Override
                public void success(Token token, Response response) {
                    spData.save(token);
                    loginScreen.onLogged();
                }

                @Override
                public void failure(RetrofitError error) {
                    showError("Error in login");
                }
            });
        }
    }


    public void clickOnRememberMyPassword() {

        showError("Not implemented yet");
    }


    private void showError(final String error) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                loginScreen.showError(error);
            }
        });
    }

    public void goToHome() {
                loginScreen.onLogged();
    }

    public void showRegisterScreen() {
        loginScreen.showRegisterScreen();
    }


    public interface LoginScreen {

        void showError(String s);

        void onLogged();

        void showRegisterScreen();
    }
}
