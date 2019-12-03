package com.example.activplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class settingsMenu extends AppCompatActivity {

    private ArrayList<String> settingsList;
    private RecyclerView todoRecyclerView;
    private RecyclerView.Adapter todoRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);

        //set up settings list
        todoRecyclerView = findViewById(R.id.settingsRecycler);
        todoRecyclerView.setHasFixedSize(true);

    }
}
