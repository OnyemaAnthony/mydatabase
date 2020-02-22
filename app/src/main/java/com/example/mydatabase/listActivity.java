package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class listActivity extends AppCompatActivity {

    private List<Student>studentList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    DatabaseHandler db;
    private  List<String> myList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);


        db = new DatabaseHandler(this);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



//        for(int i=0;i<20;i++){
//            Student student = new Student();
//            student.setName("Anthony");
//            student.setDepartment("computer");
//            student.setSchool("unn");
//            studentList.add(student);


        studentList = db.getAllStudents();

        recyclerViewAdapter = new RecyclerViewAdapter(this,studentList);



        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
