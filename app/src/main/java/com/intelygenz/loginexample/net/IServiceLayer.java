package com.intelygenz.loginexample.net;

import com.intelygenz.loginexample.model.Token;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by jose.duran on 12/12/2014.
 */
public interface IServiceLayer {

    @FormUrlEncoded
    @POST("/user/login")
    void login(@Field("user") String user, @Field("password") String pass, Callback<Token> callback);
}
