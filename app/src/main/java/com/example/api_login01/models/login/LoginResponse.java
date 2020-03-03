package com.example.api_login01.models.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("flag")
    private boolean flag;

    @SerializedName("user")
    private LoggedInUser user;


    public LoginResponse(String message, boolean flag, LoggedInUser user) {
        this.message = message;
        this.flag = flag;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LoggedInUser getUser() {
        return user;
    }

    public void setUser(LoggedInUser user) {
        this.user = user;
    }
}


//{
//        "message": "login success",
//        "flag": "true",
//        "user": {
//        "id": 1,
//        "username": "hasib",
//        "first_name": "",
//        "last_name": "",
//        "is_active": true,
//        "is_staff": false,
//        "auth_token": "fb6c1c406a66d51b1ebda6fe68599c95c585fdbd"
//        }
//}