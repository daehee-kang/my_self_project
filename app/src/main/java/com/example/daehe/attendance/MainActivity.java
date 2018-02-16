package com.example.daehe.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button attendance = (Button) findViewById(R.id.bAttendance);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attIntent = new Intent(MainActivity.this, AttendanceActivity.class);
                startActivity(attIntent);
            }
        });

        Button person = (Button) findViewById(R.id.bPerson);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent personIntent = new Intent(MainActivity.this, PersonActivity.class);
                startActivity(personIntent);
            }
        });

        Button stats = (Button) findViewById(R.id.bStats);
        Button exit = (Button) findViewById(R.id.bExit);
    }
}
