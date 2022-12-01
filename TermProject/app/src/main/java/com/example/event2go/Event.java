package com.example.event2go;

import java.util.Date;

public class Event {

    int eventID, nbPlaces;
    String title, description, type;
    Date date;

    public Event(int eventID, int nbPlaces, String title, String description, String type, Date date) {
        this.eventID = eventID;
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public Event(int nbPlaces, String title, String description, String type, Date date) {
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}