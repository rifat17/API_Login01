package com.example.api_login01.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.nio.charset.StandardCharsets;

public class LoginSession {

    public static final String PREF_NAME = "com.example.api_login01";

    public static final String LOGIN_STATUS = "loginStatus";

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static final String AUTH_TOKEN = "auth_token";


    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context mContex;




    public LoginSession(Context mContex) {
        this.mContex = mContex;
        prefs = mContex.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


    public void logout(){
        editor.clear();
        editor.commit();
    }

    public void setLoggedin(boolean logggedin) {
        editor.putBoolean(LOGIN_STATUS, logggedin);
        editor.commit();
    }

    public boolean getLoggedin() {
        return prefs.getBoolean(LOGIN_STATUS, false);
    }


    //

    public void setUsername(String username) {
        editor.putString(USERNAME, username);
        editor.commit();
    }

    public String getUsername() {
        return prefs.getString(USERNAME, "");
    }

    ///
//    public void setPassword(String password) {
//
//        String base64 = Base64.encodeToString(password, Base64.DEFAULT);
//
//
//        editor.putString(PASSWORD, password);
//        editor.commit();
//    }
//
//    public String getPassword() {
//        return prefs.getString(PASSWORD, "");
//    }

    //
    public void setAuthToken(String authToken) {
        editor.putString(AUTH_TOKEN, authToken);
        editor.commit();
    }

    public String getAuthToken() {
        return prefs.getString(AUTH_TOKEN, "");
    }


}




/*

// Sending side
byte[] data = text.getBytes(StandardCharsets.UTF_8);
String base64 = Base64.encodeToString(data, Base64.DEFAULT);

// Receiving side
byte[] data = Base64.decode(base64, Base64.DEFAULT);
String text = new String(data, StandardCharsets.UTF_8);







// Sending side
byte[] data = text.getBytes("UTF-8");
String base64 = Base64.encodeToString(data, Base64.DEFAULT);

// Receiving side
byte[] data = Base64.decode(base64, Base64.DEFAULT);
String text = new String(data, "UTF-8");





 */
