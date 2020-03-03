package com.example.api_login01.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_login01.R;
import com.example.api_login01.databinding.ActivityRegisterBinding;
import com.example.api_login01.models.register.RegistrationResponse;
import com.example.api_login01.utils.ApiInterface;
import com.example.api_login01.utils.RetrofitClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    public static final String DUPLICATE_FIELD_ERROR = "This field must be unique.";

    ActivityRegisterBinding binding;

    ApiInterface apiInterface;

    TextView username,email,password1,password2;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.tvUsername);
        email = findViewById(R.id.tvEmail);
        password1 = findViewById(R.id.tvPassword1);
        password2 = findViewById(R.id.tvPassword2);

    }


    private boolean checkBothPasswordIsEqual() {
        String upass1 = password1.getText().toString().trim();
        String upass2 = password2.getText().toString().trim();

        if(upass1.equals(upass2) && !upass1.isEmpty()){
            return true;
        }
        return false;
    }


    private boolean isEmpty() {
        String uname = username.getText().toString().trim();
        String uemail = email.getText().toString().trim();
        String upass1 = password1.getText().toString().trim();
        String upass2 = password2.getText().toString().trim();

        if(uname.isEmpty() || uemail.isEmpty() || upass1.isEmpty() || upass2.isEmpty())
            return true;
        return false;
    }

    private boolean isValidEmail(){
        String uemail = email.getText().toString().trim();
        return Patterns.EMAIL_ADDRESS.matcher(uemail).matches();
    }


    private void doRegister() {

            apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
            String uname = username.getText().toString().trim();
            String uemail = email.getText().toString().trim();
            String upass1 = password1.getText().toString().trim();
            String upass2 = password2.getText().toString().trim();


            //DEBUG PURPOSE ONLY
            //DELETE THIS
//            uname = "hasib1";
            uemail = "a.hasib.rifat@gmail.com";
            upass1 = "12345678";
            upass2 = upass1;


        Call<RegistrationResponse> register = apiInterface.register(uname, uemail, upass1, upass2);
//            Call<LoginResponse> register = apiInterface.register("ome2", "ome2@ome.com", "1234", "1234");

        register.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {

                try {
                    if(response.code() == 400){

                        Gson gson = new Gson();
                        RegistrationResponse entity = gson.fromJson(response.errorBody().string(), RegistrationResponse.class);

                        registerErrorResponse(entity);

                    }

                    if(response.code() == 201){
                        Toast.makeText(RegisterActivity.this, "Registration Successfull.Please Login", Toast.LENGTH_SHORT).show();

                        Intent loginPage = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(loginPage);
                        finish();
                    }

                }
                catch (Exception e){
                    Log.d(TAG, "onResponse: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

    }

    private void registerErrorResponse(RegistrationResponse entity) {

        Log.d(TAG, "onResponse: ALL " + entity.toString());
        Log.d(TAG, "onResponse:entrity  "+ entity.getMessage());
        Log.d(TAG, "onResponse:entrity  "+ entity.getErrorResponse().getEmail());
        Log.d(TAG, "onResponse:entrity  "+ entity.getErrorResponse().getUsername());
        String errorInEmail = entity.getErrorResponse().getEmail();
        String errorInUname = entity.getErrorResponse().getUsername();

        if(DUPLICATE_FIELD_ERROR.equalsIgnoreCase(errorInEmail) && DUPLICATE_FIELD_ERROR.equalsIgnoreCase(errorInUname) ){
            Toast.makeText(RegisterActivity.this, "Email & Username must be unique.", Toast.LENGTH_SHORT).show();
        }
        else if(DUPLICATE_FIELD_ERROR.equalsIgnoreCase(errorInUname)) {
            Toast.makeText(RegisterActivity.this, "Username must be unique.", Toast.LENGTH_SHORT).show();
        }
        else if(DUPLICATE_FIELD_ERROR.equalsIgnoreCase(errorInEmail)){
            Toast.makeText(RegisterActivity.this, "Email must be unique.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(RegisterActivity.this, entity.getErrorResponse().toString(), Toast.LENGTH_SHORT).show();

        }
    }


    public void register(View view) {

        //DEBUG_PURPOSE, DELETE THIS
        doRegister();
        return;
        //DEBUG_PURPOSE, DELETE THIS




        //unComment after DEBUG
        /*if(!isEmpty()){
            if(checkBothPasswordIsEqual() && isValidEmail() && InternetConnection.checkConnection(RegisterActivity.this)){
                doRegister();
            }
            else if(!checkBothPasswordIsEqual()) {
                Toast.makeText(this, "Passwords is not equal", Toast.LENGTH_SHORT).show();

            }
            else if(!isValidEmail()){
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Empty Fields!", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void login(View view) {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
