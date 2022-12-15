package com.example.listview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class AkashAdapter extends RecyclerView.Adapter<AkashAdapter.ViewHolder> {
    private static final String TAG = "AkashAdapter";
    private final String[] objects;
    private  ClickListener clickListener;

    public AkashAdapter(ClickListener clickListener, @NonNull String[] objects) {
        this.objects=objects;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public AkashAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_akash_layout,parent,false);

        return new ViewHolder(convertView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AkashAdapter.ViewHolder holder, int position) {
        //holder.setOnClickListener(v -> Toast.makeText(getContext(), "You've got an event " + position, Toast.LENGTH_SHORT).show());
        holder.onBind(objects[position]);
        //holder.titleText.getText();

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: count"+objects.length);
        return objects.length;
    }

    public void returnOnClickListener(ClickListener o) {
        clickListener=o;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleText;
        private ImageView coverImage;
        private ClickListener viewTouch;

        public ViewHolder(@NonNull View itemView, ClickListener click) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
            viewTouch = click;
        }

        public void onBind(String ob){
            titleText.setText(ob);
        }

        @Override
        public void onClick(View v) {
            viewTouch.onItemClick(getAdapterPosition());
        }
    }
}
