    package com.example.volleyjson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class UserManager {

    Context context;
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;

    public static final String PREF_NAME = "volleyJSON";
    public static final String Login = "is_login";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public UserManager(Context context) {
        this.context = context;
    }
    void savedUser(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(Login,true);
        editor.apply();
    }
    boolean isLoggedIn(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(Login,false);
    }
    public User getUser(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return new User(sharedPreferences.getString(USERNAME,null),
                sharedPreferences.getString(EMAIL,null));
    }



    public void logout(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
