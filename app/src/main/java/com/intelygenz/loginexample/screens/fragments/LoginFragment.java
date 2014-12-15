package com.intelygenz.loginexample.screens.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.intelygenz.loginexample.R;
import com.intelygenz.loginexample.modules.login.LoginSubviewPresenterModule;
import com.intelygenz.loginexample.presenters.LoginSubviewPresenter;
import com.intelygenz.loginexample.screens.activities.GraphActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dagger.ObjectGraph;

/**
 * Created by jose.duran on 15/12/2014.
 */
public class LoginFragment extends Fragment implements LoginSubviewPresenter.LoginSubviewScreen {
    public static String TAG = LoginFragment.class.getSimpleName();

    @Inject
    LoginSubviewPresenter mLoginSubviewPresenter;

    @InjectView(R.id.et_user_name)
    EditText mUserName;
    @InjectView(R.id.et_user_pass)
    EditText mUserPass;

    private ObjectGraph mObjectGraph;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            GraphActivity graphActivity = (GraphActivity) activity;
            mObjectGraph = graphActivity.getObjectGraph();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mObjectGraph != null) {
            mObjectGraph = mObjectGraph.plus(new LoginSubviewPresenterModule());
            mObjectGraph.inject(this);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.inject(this, view);

        mLoginSubviewPresenter.setScreen(this);

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mObjectGraph = null;
    }

    @OnClick(R.id.bt_login)
    public void onLoginClicked() {
        mLoginSubviewPresenter.clickOnLogin(mUserName.getText().toString(), mUserPass.getText().toString());
    }

    @OnClick(R.id.bt_new_user)
    public void onNewUserClicked() {
        mLoginSubviewPresenter.clickOnNewUser();
    }


}
