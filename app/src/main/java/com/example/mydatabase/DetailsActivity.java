package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView name,department,school;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.namedetails);

        department = findViewById(R.id.departmentDetails);
        school = findViewById(R.id.schoolDetails);
        bundle = getIntent().getExtras();

        if (bundle != null){
            name.setText(bundle.getString("name"));
            department.setText(bundle.getString("department"));
            school.setText(bundle.getString("school"));
        }


    }
}
