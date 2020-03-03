package com.example.api_login01.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_login01.R;
import com.example.api_login01.databinding.ActivityRoomDetails2Binding;
import com.example.api_login01.models.room.RoomDetailsResponse;
import com.example.api_login01.utils.ApiInterface;
import com.example.api_login01.utils.RetrofitClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomDetails extends AppCompatActivity {
    private static final String TAG = "RoomDetails";

    ApiInterface apiInterface;
    RoomDetailsResponse roomDetailsResponse;

    ImageView imageView;
    TextView name, address, price,discount, space, bedroom, food, rules, email, cell, web;
    ActivityRoomDetails2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details2);

        imageView = findViewById(R.id.image1);
        address = findViewById(R.id.textviewaddress);
        price = findViewById(R.id.textviewprice);
        discount = findViewById(R.id.textviewdiscount);
        space = findViewById(R.id.space);
        bedroom = findViewById(R.id.noOfBedroom);
        food = findViewById(R.id.foodStatus);
        rules = findViewById(R.id.tvRule);
        email = findViewById(R.id.tvEmail);
        cell = findViewById(R.id.tvcell);
        web = findViewById(R.id.tvweb);

//        Log.d(TAG, "onCreate: " + getIntent().getStringExtra("id").getClass().getName());
       String selectedRoom = getIntent().getStringExtra("id");

        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        apiInterface.getRoom(selectedRoom).enqueue(new Callback<RoomDetailsResponse>() {
            @Override
            public void onResponse(Call<RoomDetailsResponse> call, Response<RoomDetailsResponse> response) {
                if(response.code() == 200 ){

                    loadData(response.body());

                    Log.d(TAG, "onResponse: GetRoomDetail " + response.body().getRname());
                }
            }

            @Override
            public void onFailure(Call<RoomDetailsResponse> call, Throwable t) {

            }
        });



//        Toast.makeText(this, "" + getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();


    }

    private void loadData(RoomDetailsResponse body) {
//    TextView name, address, price,discount, space, bedroom, food, rules, email, cell, web;
        try{
            Picasso.get().load(body.getRphoto()).into(imageView);
            address.setText(body.getRhotel().getAddress());
            price.setText(body.getRprice());
            discount.setText(body.getRdiscount());
            space.setText(body.getRProperty().getSqfeet());
            bedroom.setText(body.getRProperty().getNoOfBed());
            food.setText(String.valueOf(body.getRProperty().getFood()));
            rules.setText("Rules : \n" +body.getRProperty().getRules());
            email.setText("Email :  " +body.getRhotel().getEmail());
            cell.setText("Cell :  " +body.getRhotel().getMobileNumber());
            web.setText("Web :  " +body.getRhotel().getWebsite());
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

}
