package com.example.eventorganiser;

import java.util.Date;

public class Event {

    int eventID, typeID, nbPlaces;
    String title, description;
    Date date;

    public Event(int eventID, int typeID, int nbPlaces, String title, String description, Date date) {
        this.eventID = eventID;
        this.typeID = typeID;
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Event(int typeID, int nbPlaces, String title, String description, Date date) {
        this.typeID = typeID;
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
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
