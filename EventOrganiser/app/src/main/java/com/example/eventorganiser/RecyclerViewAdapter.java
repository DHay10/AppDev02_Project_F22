package com.example.eventorganiser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private List<String> eventTitleDisplay;
    private List<String> eventDateDisplay;
    private LayoutInflater inflator;


    public RecyclerViewAdapter(Context context, List<String> eventTitleDisplay, List<String>eventDateDisplay) {
       this.eventTitleDisplay = eventTitleDisplay;
        this.eventDateDisplay = eventDateDisplay;
        this.inflator = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.eventlist_recycler, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        String s = eventTitleDisplay.get(position);
        String a = eventDateDisplay.get(position);
        holder.eventTitleD.setText(s);
        holder.eventDateD.setText(s);


    }

    @Override
    public int getItemCount() {
        return eventDateDisplay.size() & eventTitleDisplay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView eventTitleD, eventDateD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitleD = itemView.findViewById(R.id.gameTitle);
            eventDateD = itemView.findViewById(R.id.gameDate);

        }
    }



}
