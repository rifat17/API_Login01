package com.example.api_login01.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.api_login01.R;
import com.example.api_login01.models.room.RoomRes;
import com.example.api_login01.utils.ApiInterface;
import com.example.api_login01.utils.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.api_login01.utils.utilities.BACKEND_BASE_URL;

public class RoomListRecycleView extends AppCompatActivity {
    private static final String TAG = "RoomListRecycleView";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
//    RecycleViewAdapter adapter;

    private List<RoomRes> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list_recycle_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        LoadRecycleview();
    }

    private void LoadRecycleview() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BACKEND_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        final ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<RoomRes>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<RoomRes>>() {
            @Override
            public void onResponse(Call<List<RoomRes>> call, Response<List<RoomRes>> response) {
                List<RoomRes> posts = response.body();
                Log.d(TAG, "onResponse: " + response.code());
                for(RoomRes post : posts) {

                    RoomRes nRoom = new RoomRes(
                            post.getId(),
                            post.getRname(),
                            post.getRphoto(),
                            post.getRprice(),
                            post.getAddress()
                    );
//                    Log.d(TAG, "onResponse: " + nRoom.getId());
                    listItems.add(nRoom);

                }
                Log.d(TAG, "onResponse: RoomListRecycleView " + listItems.size());
                adapter = new RecycleViewAdapter(listItems, RoomListRecycleView.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<RoomRes>> call, Throwable t) {

            }
        });

    }
}
