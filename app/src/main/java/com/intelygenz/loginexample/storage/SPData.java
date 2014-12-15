package com.intelygenz.loginexample.storage;

import android.content.Context;

import com.intelygenz.loginexample.model.Token;

/**
 * Created by jose.duran on 12/12/2014.
 */
public class SPData implements ISPData{
    private Context context;

    public SPData(Context context){
        this.context = context;
    }

    @Override
    public void save(Token token) {

    }
}
