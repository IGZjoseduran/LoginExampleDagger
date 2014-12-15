package com.intelygenz.loginexample.utils;

/**
 * Created by jose.duran on 12/12/2014.
 */
public interface ILoginChecker {
    boolean isValidUser(String user);

    boolean isValidPassword(String password);
}
