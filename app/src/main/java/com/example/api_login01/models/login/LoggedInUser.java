package com.example.api_login01.models.login;

import com.google.gson.annotations.SerializedName;

public class LoggedInUser {

    @SerializedName("id")
    private int userid;

    @SerializedName("username")
    private String username;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("is_active")
    private boolean active;

    @SerializedName("is_staff")
    private boolean staff;

    @SerializedName("auth_token")
    private String token;


    public LoggedInUser(int userid, String username, String firstName, String lastName, boolean active, boolean staff, String token) {
        this.userid = userid;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.staff = staff;
        this.token = token;
    }


    public LoggedInUser(int userid, String username, boolean staff, String token) {
        this.userid = userid;
        this.username = username;
        this.staff = staff;
        this.token = token;
    }


    public LoggedInUser(int userid, String username, String token) {
        this.userid = userid;
        this.username = username;
        this.token = token;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}



//    "user": {
//            "id": 1,
//            "username": "hasib",
//            "first_name": "",
//            "last_name": "",
//            "is_active": true,
//            "is_staff": false,
//            "auth_token": "fb6c1c406a66d51b1ebda6fe68599c95c585fdbd"