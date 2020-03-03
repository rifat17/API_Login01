package com.example.api_login01.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.api_login01.R;
import com.example.api_login01.utils.LoginSession;

public class HomeActivity extends AppCompatActivity {

    LoginSession loginSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginSession = new LoginSession(getApplicationContext());




        Toast.makeText(this, loginSession.getUsername(), Toast.LENGTH_SHORT).show();
    }

    public void logout(View view) {
        loginSession.logout();
        finish();
    }
}
