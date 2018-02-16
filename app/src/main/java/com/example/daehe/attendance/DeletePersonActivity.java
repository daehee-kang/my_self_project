package com.example.daehe.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DeletePersonActivity extends AppCompatActivity {

    PersonDBConnection conn = new PersonDBConnection(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_person_layout);

        ListView lvView = (ListView) findViewById(R.id.lvPerson);
        List<Person> people = conn.getAllPeople();
        List<String> peopleString = new ArrayList<String>();
        for(Person p : people){
            peopleString.add(p.toString());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, peopleString);
        lvView.setAdapter(arrayAdapter);
    }
}
