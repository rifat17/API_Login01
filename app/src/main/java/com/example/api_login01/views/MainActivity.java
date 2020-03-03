package com.example.api_login01.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_login01.R;
import com.example.api_login01.models.login.LoggedInUser;
import com.example.api_login01.models.login.LoginResponse;
import com.example.api_login01.utils.ApiInterface;
import com.example.api_login01.utils.InternetConnection;
import com.example.api_login01.utils.LoginSession;
import com.example.api_login01.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    public static final int MIN_USERNAME_LENGTH = 4;
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final int DEFAULT_LENGTH = 4;

    ApiInterface apiInterface;
    LoginSession loginSession;

    TextView username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.tvUsername);
        password = findViewById(R.id.tvPassword);


        loginSession = new LoginSession(
                //context
                getApplicationContext());
//        loginSession.logout();


        if(loginSession.getLoggedin()){
            goToHomePage();
        }


    }

    private void goToHomePage() {
        Intent intent = new Intent(MainActivity.this, RoomListRecycleView.class);

        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:

                login(v);

                break;
            case R.id.tvRegister:
                register(v);

                break;

        }

    }


    public void login(View view) {

        chechValidation(username);
        chechValidation(password);

        // Check Internate Connectivity
        if(InternetConnection.checkConnection(getApplicationContext())){
            //do login
            userLogin(
                    username.getText().toString(),
                    password.getText().toString()
            );
        }
        else {
            Toast.makeText(this, "No Internet", Toast.LENGTH_LONG).show();
        }
    }




    public void register(View view) {

        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }


    private void userLogin(String username, String password) {
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        Call<LoginResponse> login = apiInterface.getUserLogin(username, password);

        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.code() == 200){
                    Log.d(TAG, "onResponse: " + response.body().getUser().getToken());
                    LoginResponse loginResponse = response.body();

                    LoggedInUser loggedInUser = loginResponse.getUser();
                    loginSession.setLoggedin(loginResponse.isFlag());
                    loginSession.setUsername(loggedInUser.getUsername());
                    loginSession.setAuthToken(loggedInUser.getToken());

                    goToHomePage();
                }else {
                    Toast.makeText(MainActivity.this, "Wrong creditantial", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage() + "MAINACTIVITY - USERLOGIN", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void chechValidation(TextView textView) {
        if(textView.getText().toString().isEmpty()){
            textView.setError("Cannot be empty");
        }

        int len = 0;

        switch (textView.getId()){
            case R.id.tvUsername:
                len = MIN_USERNAME_LENGTH;
                break;
            case R.id.tvPassword:
                len = MIN_PASSWORD_LENGTH;
                default:
                    len = DEFAULT_LENGTH;
        }

        int finalLen = len;
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



                if(s.length() >= finalLen)
                    textView.setError(null);

            }
        });
    }





}
