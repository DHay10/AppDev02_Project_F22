package com.example.goevent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    ArrayList<Event> list;
    private SelectListener listener;

    public RecyclerViewAdapter(Context context, ArrayList<Event> list, SelectListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.events, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Event event = list.get(position);
        holder.ename.setText(event.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        EditText edate, ename, eattendees;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edate = itemView.findViewById(R.id.eventDate);
            ename = itemView.findViewById(R.id.event1);
            eattendees = itemView.findViewById(R.id.attendeesnum);
        }
    }
}

