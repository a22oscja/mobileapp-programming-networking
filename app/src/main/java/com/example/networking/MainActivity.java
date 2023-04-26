package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    Gson gson = new Gson();
    RecyclerView recView;
    CustomAdapter customAdapter;
    ArrayList<Mountain> listOfMountains = new ArrayList<Mountain>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recView = findViewById(R.id.recView);
        customAdapter = new CustomAdapter(listOfMountains);
        recView.setAdapter(customAdapter);
        recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        new JsonFile(this,this).execute(JSON_FILE);
        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json)
    {
        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        listOfMountains = gson.fromJson(json, type);
        Log.d("cope", "onPostExecute: "+listOfMountains.size());
        customAdapter.UpdateList(listOfMountains);
        customAdapter.notifyDataSetChanged();

        for (Mountain m : listOfMountains){
            Log.d("waow", m.toString());
        }
        Log.d("MainActivity", json);
    }

}
