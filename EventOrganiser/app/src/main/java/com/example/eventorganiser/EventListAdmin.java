package com.example.eventorganiser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventListAdmin extends AppCompatActivity {

    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_admin);

        //HOW DO U ADD CREATED EVENTS IN THISSSSSS
        ArrayList<String> createdEvents = new ArrayList<>();
        ArrayList<String> createdDate = new ArrayList<>();



        RecyclerView recyclerView = findViewById(R.id.eventListAdminView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, createdEvents, createdDate );
        recyclerView.setAdapter(adapter);

    }

    }
