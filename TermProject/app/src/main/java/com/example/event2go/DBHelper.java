package com.example.event2go;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sqlDB;
    public static final String DB_NAME = "goEvent.db";
    public static final int DB_VERSION = 1;
    private static final String TABLE_ADMIN = "ADMIN";
    private static final String TABLE_USER = "USER";
    private static final String TABLE_EVENT = "EVENT";

    private static final String CREATE_ADMIN = "create table ADMIN (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username VARCHAR NOT NULL, password VARCHAR NOT NULL);";

    private static final String CREATE_USER = "create table USER (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username VARCHAR NOT NULL, email VARCHAR NOT NULL, password VARCHAR NOT NULL, " +
            "fname VARCHAR NOT NULL, lname VARCHAR NOT NULL, phone VARCHAR NOT NULL);";

    private static final String CREATE_EVENT = "create table EVENT (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "title VARCHAR NOT NULL, type VARCHAR NOT NULL, description TEXT NOT NULL, " +
            "places NUM NOT NULL, date DATE NOT NULL);";

    public DBHelper (Context context){
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ADMIN);
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_EVENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS ADMIN ");
        db.execSQL(" DROP TABLE IF EXISTS USER ");
        db.execSQL(" DROP TABLE IF EXISTS EVENT ");
        onCreate(db);
    }

    public boolean addUser(User user) {
        sqlDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("fname", user.getFname());
        contentValues.put("lname", user.getLname());
        contentValues.put("email", user.getEmail());
        contentValues.put("phone", user.getPhone());
        sqlDB.insert(DBHelper.TABLE_USER, null ,contentValues);
        sqlDB.close();
        return true;
    }

    public boolean updateUser(User user) {
        sqlDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("fname", user.getFname());
        contentValues.put("lname", user.getLname());
        contentValues.put("email", user.getEmail());
        contentValues.put("phone", user.getPhone());
        sqlDB.update(DBHelper.TABLE_USER, contentValues, " ID = ? ",
                new String[] {String.valueOf(user.getId())});
        return true;
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM " + TABLE_USER;
        sqlDB = this.getReadableDatabase();
        List<User> Users = new ArrayList<>();
        Cursor cursor = sqlDB.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String username = cursor.getString(1);
                String password_hash = cursor.getString(2);
                String fname = cursor.getString(3);
                String lname = cursor.getString(4);
                String email = cursor.getString(5);
                String phone = cursor.getString(6);
                Users.add(new User(id, username, password_hash, fname, lname, email, phone));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return Users;
    }

    public User getUserByID(int userID) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE ID = " + String.valueOf(userID);
        sqlDB = getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery(sql, null);
        int id = Integer.parseInt(cursor.getString(0));
        String username = cursor.getString(1);
        String password_hash = cursor.getString(2);
        String fname = cursor.getString(3);
        String lname = cursor.getString(4);
        String email = cursor.getString(5);
        String phone = cursor.getString(6);
        cursor.close();
        return new User(id, username, password_hash, fname, lname, email, phone);
    }

    public User getUserByUsername(String name) {
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE USERNAME = " + name;
        sqlDB = getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery(sql, null);
        int id = Integer.parseInt(cursor.getString(0));
        String username = cursor.getString(1);
        String password_hash = cursor.getString(2);
        String fname = cursor.getString(3);
        String lname = cursor.getString(4);
        String email = cursor.getString(5);
        String phone = cursor.getString(6);
        cursor.close();
        return new User(id, username, password_hash, fname, lname, email, phone);
    }
}
