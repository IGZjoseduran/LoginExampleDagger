package com.intelygenz.loginexample.screens.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.intelygenz.loginexample.R;

import butterknife.ButterKnife;
import dagger.ObjectGraph;


public class HomeActivity extends ActionBarActivity  {



    private ObjectGraph mObjectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        ExampleLoginApp app = (ExampleLoginApp) getApplication();
//        mObjectGraph = app.plusModules(new LoginPresenterModule(), new ILoginCheckerModule());
//        mObjectGraph.inject(this);


        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObjectGraph = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
