package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submitButton;
    private EditText name,department;
    private AutoCompleteTextView school;

    DatabaseHandler db;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(MainActivity.this);
        Log.d(TAG, "onCreate: " +db.getCount());
        if (db.getCount() > 0) {
            startActivity(new Intent(MainActivity.this,listActivity.class));

        }



        submitButton = findViewById(R.id.addButton);
        name = findViewById(R.id.namedetails);
        department = findViewById(R.id.Department);
        school = findViewById(R.id.school);

       submitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String nameText = name.getText().toString().trim();
               String departmentText = department.getText().toString().trim();
               String mySchool = school.getText().toString().trim();

               if (!nameText.isEmpty() && !departmentText.isEmpty() && !mySchool.isEmpty()) {
                   startActivity(new Intent(MainActivity.this, listActivity.class));
                   finish();
                   Student student = new Student();
                   student.setName(nameText);
                   student.setDepartment(departmentText);
                   student.setSchool(mySchool);
                   db.addStudent(student);
               }else {
                   Toast.makeText(MainActivity.this, "Empty fields are not allowed" , Toast.LENGTH_SHORT).show();
               }
           }
       });


    }


}
