package com.intelygenz.loginexample.net;


import retrofit.RestAdapter;

public class ApiModule {
    private static final String APIARY_END_POINT = "http://private-44b30-mockupapp.apiary-mock.com/";

    public static IServiceLayer getAPIaryService() {
        return getAdapter(APIARY_END_POINT).create(IServiceLayer.class);
    }

    private static RestAdapter getAdapter(String endPoint) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return restAdapter;
    }

}
