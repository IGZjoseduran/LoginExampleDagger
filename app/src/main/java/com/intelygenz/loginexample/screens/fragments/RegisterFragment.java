package com.intelygenz.loginexample.screens.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.intelygenz.loginexample.R;
import com.intelygenz.loginexample.modules.login.RegisterPresenterModule;
import com.intelygenz.loginexample.presenters.RegisterPresenter;
import com.intelygenz.loginexample.screens.activities.GraphActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.ObjectGraph;

/**
 * Created by jose.duran on 15/12/2014.
 */
public class RegisterFragment extends Fragment implements RegisterPresenter.RegisterScreen {
    public static String TAG = RegisterFragment.class.getSimpleName();


    @Inject
    RegisterPresenter mRegisterPresenter;

    private ObjectGraph mObjectGraph;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
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
            mObjectGraph = mObjectGraph.plus(new RegisterPresenterModule());
            mObjectGraph.inject(this);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.inject(this, view);

        mRegisterPresenter.setScreen(this);
        return view;
    }


    @OnClick(R.id.bt_go_to_home)
    public void onClickGoToHome() {
        mRegisterPresenter.onClickGoToHome();
    }

    @OnClick(R.id.bt_register_fragment)
    public void onClickRegisterfragment() {
        mRegisterPresenter.onClickRegisterFragment();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}
