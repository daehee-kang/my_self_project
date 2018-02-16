package com.example.daehe.attendance;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPersonActivity extends AppCompatActivity {

    PersonDBConnection conn = new PersonDBConnection(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_layout);

        Button addPerson = (Button) findViewById(R.id.bAddPersonItem);
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lName = (EditText) findViewById(R.id.etLastName);
                EditText fName = (EditText) findViewById(R.id.etFirstName);
                EditText age = (EditText) findViewById(R.id.etAge);
                EditText phone = (EditText) findViewById(R.id.etPhone);
                EditText address = (EditText) findViewById(R.id.etAddress);

                Person person = new Person(
                        lName.getText().toString(),
                        fName.getText().toString(),
                        phone.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        address.getText().toString()
                );
                conn.addPerson(person);
            }
        });
    }
}
