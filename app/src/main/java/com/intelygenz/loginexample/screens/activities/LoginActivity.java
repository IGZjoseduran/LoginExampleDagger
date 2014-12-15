package com.intelygenz.loginexample.screens.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.intelygenz.loginexample.R;
import com.intelygenz.loginexample.app.ExampleLoginApp;
import com.intelygenz.loginexample.modules.login.ILoginCheckerModule;
import com.intelygenz.loginexample.modules.login.LoginPresenterModule;
import com.intelygenz.loginexample.presenters.LoginPresenter;
import com.intelygenz.loginexample.screens.fragments.LoginFragment;
import com.intelygenz.loginexample.screens.fragments.RegisterFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import dagger.ObjectGraph;


public class LoginActivity extends ActionBarActivity implements LoginPresenter.LoginScreen, GraphActivity {

    @Inject
    LoginPresenter mLoginPresenter;


    private ObjectGraph mObjectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ExampleLoginApp app = (ExampleLoginApp) getApplication();
        mObjectGraph = app.plusModules(new LoginPresenterModule(), new ILoginCheckerModule());
        mObjectGraph.inject(this);

        mLoginPresenter.setScreen(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, LoginFragment.newInstance(), LoginFragment.TAG).commit();
    }

    @Override
    public ObjectGraph getObjectGraph(){
        return mObjectGraph;
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showError(String s) {
        Toast.makeText(this, "On Activity: " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogged() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showRegisterScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, RegisterFragment.newInstance(), RegisterFragment.TAG).commit();
    }
}
