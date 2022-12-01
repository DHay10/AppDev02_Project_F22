package com.example.eventorganiser;

public class User {

    int id;

    String username, password_hash, fname, lname, email, phone;

    public User(int id, String username, String password_hash, String fname, String lname, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password_hash, String fname, String lname,
                String email, String phone) {
        this.username = username;
        this.password_hash = password_hash;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    public User(int id, String name, String phone, String age) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password_hash, String email) {
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
