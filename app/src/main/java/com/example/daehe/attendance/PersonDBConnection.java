package com.example.daehe.attendance;

/**
 * Created by Daehee on 2018-02-09.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonDBConnection extends DBConnection{

    // Contacts table name
    private static final String TABLE_PEOPLE = "PeopleTable";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LAST_NAME = "lname";
    private static final String KEY_FIRST_NAME = "fname";
    private static final String KEY_AGE = "age";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_ADDRESS = "address";

    public PersonDBConnection(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PEOPLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_LAST_NAME + " TEXT NOT NULL, "
                + KEY_FIRST_NAME + " TEXT NOT NULL, "
                + KEY_PHONE + " TEXT NOT NULL, "
                + KEY_AGE + " INTEGER, "
                + KEY_ADDRESS + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
        // Creating tables again
        onCreate(db);
    }

    public void addPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LAST_NAME, person.getLastName());
        values.put(KEY_FIRST_NAME, person.getFirstName());
        values.put(KEY_PHONE, person.getPhone());
        if(person.getAge() != 0){
            values.put(KEY_AGE, person.getAge());
        }
        if(!person.getAddress().equals(""))
        {
            values.put(KEY_ADDRESS, person.getAddress());
        }

        db.insert(TABLE_PEOPLE, null, values);
        db.close(); // Closing database connection
    }

    public Person getPerson(String lastName, String firstName, String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_PEOPLE,
                new String[] { KEY_ID, KEY_LAST_NAME, KEY_FIRST_NAME, KEY_PHONE, KEY_AGE, KEY_ADDRESS },
                KEY_LAST_NAME + "=? AND " + KEY_FIRST_NAME + "=? AND " + KEY_PHONE + "=?",
                new String[] { lastName, firstName, phone },
                null,
                null,
                null,
                null
        );

        if (cursor != null)
            cursor.moveToFirst();

        Person person = new Person(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)),
                cursor.getString(5)
        );

        return person;
    }

    public List<Person> getAllPeople() {
        List<Person> peopleList = new ArrayList<Person>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PEOPLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        Integer.parseInt(cursor.getString(4)),
                        cursor.getString(5)
                );
                // Adding contact to list
                peopleList.add(person);
            } while (cursor.moveToNext());
        }
        // return contact list
        return peopleList;
    }

    public int getPeopleCount() {
        String countQuery = "SELECT * FROM " + TABLE_PEOPLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }

    public int updatePerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_LAST_NAME, person.getLastName());
        values.put(KEY_FIRST_NAME, person.getFirstName());
        values.put(KEY_PHONE, person.getPhone());
        values.put(KEY_AGE, person.getAge());
        values.put(KEY_ADDRESS, person.getAddress());
        // updating row
        return db.update(
                TABLE_PEOPLE,
                values,
                KEY_LAST_NAME + " =? AND " + KEY_FIRST_NAME + " =? AND " + KEY_PHONE + " =?" ,
                new String[]{ person.getLastName(), person.getFirstName(), person.getPhone() });
    }

    public void deletePerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PEOPLE,
                KEY_LAST_NAME + " =? AMD " + KEY_FIRST_NAME + " =? AND " + KEY_PHONE + " =?",
                new String[] { person.getLastName(), person.getFirstName(), person.getPhone() });
        db.close();
    }


    public void close(){
        this.close();
    }
}
