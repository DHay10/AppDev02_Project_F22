package com.example.goevent;

import java.util.Date;

public class Event {
    String eventID, title, description, type, date;
    int nbPlaces;
//    Date date;

    public Event() {

    }

    public Event(String eventID, int nbPlaces, String title, String description, String type, String date) {
        this.eventID = eventID;
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public Event(int nbPlaces, String title, String description, String type, String date) {
        this.nbPlaces = nbPlaces;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
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

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
