package com.example.api_login01.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_login01.R;
import com.example.api_login01.models.room.RoomRes;
import com.example.api_login01.views.RoomDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";

    private List<RoomRes> listitems;
    private Context context;

    public RecycleViewAdapter(List<RoomRes> listItems, Context context) {
        this.listitems = listItems;
        this.context = context;
//        Log.d(TAG, "RecycleViewAdapter: " + listItems.size());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {


        final RoomRes roomRes = listitems.get(position);
        holder.textViewName.setText(roomRes.getRname());
        holder.textViewAddress.setText(roomRes.getAddress());
        holder.textViewPrice.setText(roomRes.getRprice());
        Picasso.get().load(roomRes.getRphoto()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RoomDetails.class);
                intent.putExtra("id",listitems.get(position).getId().toString());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewAddress;
        TextView textViewRating;
        TextView textViewRatingPer;
        TextView textViewPrice;
        ImageView imageView;
        ConstraintLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textviewname);
            textViewAddress = itemView.findViewById(R.id.textviewaddress);
            textViewRating = itemView.findViewById(R.id.textviewrating);
            textViewRatingPer = itemView.findViewById(R.id.textviewtpeople);
            textViewPrice = itemView.findViewById(R.id.textviewprice);

            imageView = itemView.findViewById(R.id.image1);

//            itemView = itemView.findViewById(R.id.image1);
            linearLayout = itemView.findViewById(R.id.ListParent);
        }
    }
}
