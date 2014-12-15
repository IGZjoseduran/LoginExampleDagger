package com.intelygenz.loginexample.utils;

import android.text.TextUtils;

/**
 * Created by jose.duran on 12/12/2014.
 */
public class ServerLoginChecker implements ILoginChecker {


    @Override
    public boolean isValidUser(String user) {
        if(TextUtils.isEmpty(user)){
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidPassword(String password) {
        if(TextUtils.isEmpty(password)){
            return false;
        }

        return true;
    }
}
