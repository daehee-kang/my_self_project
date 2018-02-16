package com.example.daehe.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {

    PersonDBConnection conn = new PersonDBConnection(this);
    boolean isLongPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        isLongPressed = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_layout);

        ListView lvView = (ListView) findViewById(R.id.lvPerson);
        ArrayList<Person> people = (ArrayList<Person>) conn.getAllPeople();
        PersonAdapter adapter = new PersonAdapter(this, people);

        lvView.setAdapter(adapter);
        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent addPersonActivity = new Intent(PersonActivity.this, AddPersonActivity.class);
                startActivity(addPersonActivity);
            }
        });
        lvView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                for(int index=0; index<parent.getChildCount(); ++index) {
                    View nextChild = (parent.getChildAt(index));
                    CheckBox checkBox = (CheckBox) nextChild.findViewById(R.id.cbLongClick);
                    checkBox.setVisibility(View.VISIBLE);
                }

                CheckBox checkBox = (CheckBox) view.findViewById(R.id.cbLongClick);
                checkBox.setChecked(true);
                checkBox.setVisibility(View.VISIBLE);
                return true;
            }
        });
    }
}
