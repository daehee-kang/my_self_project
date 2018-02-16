package com.example.daehe.attendance;

/**
 * Created by Daehee on 2018-02-09.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupDBConnection extends DBConnection{

    // Contacts table name
    private static final String TABLE_GROUP = "GroupTable";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CYCLE = "cycle";
    private static final String KEY_START_DATE = "startDate";
    private static final String KEY_PEOPLE = "listOfPeople";
    public GroupDBConnection(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_GROUP + "("
                + KEY_ID + " INTEGER PRIMARY KEY"
                + KEY_NAME + " TEXT NOT NULL"
                + KEY_CYCLE + " TEXT NOT NULL"
                + KEY_START_DATE + " DATE"
                + KEY_PEOPLE + " BLOB"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUP);
        // Creating tables again
        onCreate(db);
    }

    public void close(){
        this.close();
    }
}
