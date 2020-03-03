package com.example.api_login01.models.login;

import android.util.Patterns;

public class RegisterUser {


    public final int PASSWORD_MIN_LENGTH = 4;

    private String strUsername;
    private String strEmail;
    private String strPassword1;
    private String strPassword2;

    public RegisterUser(String strUsername, String strEmail, String strPassword1, String strPassword2) {
        this.strUsername = strUsername;
        this.strEmail = strEmail;
        this.strPassword1 = strPassword1;
        this.strPassword2 = strPassword2;
    }

    public RegisterUser() {

    }


    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public boolean isValidEMail(){
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmail()).matches();
    }

    public String getStrPassword1() {
        return strPassword1;
    }

    public void setStrPassword1(String strPassword1) {
        this.strPassword1 = strPassword1;
    }

    public String getStrPassword2() {
        return strPassword2;
    }

    public void setStrPassword2(String strPassword2) {
        this.strPassword2 = strPassword2;
    }

    public boolean isPasswordGraterThanMinLength(){
        return getStrPassword1().length() >= PASSWORD_MIN_LENGTH;
    }
}
