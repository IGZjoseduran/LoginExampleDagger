package com.intelygenz.loginexample.presenters;

/**
 * Created by jose.duran on 15/12/2014.
 */
public class RegisterPresenter {

    private LoginPresenter mLoginPresenter;
    private RegisterScreen mRegisterScreen;


    public RegisterPresenter(LoginPresenter loginPresenter){
        this.mLoginPresenter = loginPresenter;
    }

    public void setScreen(RegisterScreen registerScreen){
        mRegisterScreen = registerScreen;
    }

    public void onClickGoToHome() {
        mLoginPresenter.goToHome();
    }

    public void onClickRegisterFragment(){
        mRegisterScreen.showToast("RegisterPresenter: Click!");
    }

    public interface RegisterScreen {

        public void showToast(String s);
    }
}
