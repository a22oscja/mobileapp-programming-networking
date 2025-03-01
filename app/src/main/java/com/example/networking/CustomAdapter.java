package com.example.networking;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<Mountain> mountains;
    public CustomAdapter(ArrayList<Mountain> mountains) {
        this.mountains = mountains;
    }

    public void UpdateList(ArrayList<Mountain> m){
        mountains = m;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_layout,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Mountain m = mountains.get(position);
        holder.name.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
