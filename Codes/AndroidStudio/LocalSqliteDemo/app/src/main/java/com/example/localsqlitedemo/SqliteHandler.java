package com.example.localsqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by taharushain on 4/5/17.
 */

public class SqliteHandler extends SQLiteOpenHelper {

    private static final String TAG = SqliteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "com.example.localsqlitedemo";

    // Login table name
    private static final String TABLE_USER = "users";

    // Login Table Columns names
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";






    public SqliteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_NAME + " TEXT,"
                + KEY_AGE + " INTEGER"
                + ")";

        db.execSQL(CREATE_LOGIN_TABLE);



        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String name, int age) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_AGE, age); // age


        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);

        Log.d("SqliteHandler","=================================");
        Log.d("SqliteHandler",""+name);


        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put(KEY_NAME, cursor.getString(0));
            user.put(KEY_AGE, cursor.getString(1));
        }

        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Cleared all user info from sqlite");
    }




    public void updateUserName(int user_id, String name, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_AGE, age);
        String[] args = new String[]{user_id+""};
        db.update(TABLE_USER, values, "_id=?", args);
        db.close();
    }

    private void removeUser(int user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = new String[]{user_id+""};
        db.delete(TABLE_USER, "_id=?", args);
        db.close();
    }
}