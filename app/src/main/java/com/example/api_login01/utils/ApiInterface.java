package com.example.api_login01.utils;

import com.example.api_login01.models.login.LoginResponse;
import com.example.api_login01.models.register.RegistrationResponse;
import com.example.api_login01.models.room.RoomDetailsResponse;
import com.example.api_login01.models.room.RoomRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {


        @FormUrlEncoded
        @POST("user/api/login/")
        Call<LoginResponse>  getUserLogin(
                @Field("username") String username,
                @Field("password") String password
        );


        @FormUrlEncoded
        @POST("/user/api/register/")
        Call<RegistrationResponse>  register(
                @Field("username") String username,
                @Field("email") String email,
                @Field("password") String password,
                @Field("confirm_password") String confirm_password
        );

        @GET("hotelroom")
        Call<List<RoomRes>> getPosts();


        @GET("hotelroom/{roomid}")
        Call<RoomDetailsResponse> getRoom(@Path("roomid") String roomid);

//        @POST("/api/users")
//        Call<User> createUser(@Body User user);
//
//        @GET("/api/users?")
//        Call<UserList> doGetUserList(@Query("page") String page);
//
//        @FormUrlEncoded
//        @POST("/api/users?")
//        Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
