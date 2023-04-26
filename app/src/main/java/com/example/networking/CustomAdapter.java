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
        Log.d("vieholder", "customaddaperter constructor: inside");
    }

    public void UpdateList(ArrayList<Mountain> m){
        mountains = m;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("vieholder", "onCreateViewHolder: inside");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_layout,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Mountain m = mountains.get(position);
        Log.d("test", holder.name.getText().toString());
        holder.name.setText(m.getName());
        Log.d("test2", holder.name.getText().toString());
    }

    @Override
    public int getItemCount() {
        Log.d("cope", "getItemCount: "+ mountains.size());
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
