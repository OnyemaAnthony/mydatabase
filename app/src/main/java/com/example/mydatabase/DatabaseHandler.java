package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, "student", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE students (id INTEGER PRIMARY KEY, name TEXT, department TEXT, school TEXT)";
        db.execSQL(statement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "DROP TABLE IF EXISTS students";
        db.execSQL(dropTable);
        onCreate(db);

    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("department", student.getDepartment());
        values.put("school",student.getSchool());

        db.insert("students",null,values);
        db.close();
    }

    public List<Student> getAllStudents(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Student>studentList = new ArrayList<>();

        String selectAll = "SELECT * FROM students";
        Cursor cursor = db.rawQuery(selectAll,null);

        if (cursor.moveToFirst()){

            do {
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setDepartment(cursor.getString(2));
                student.setSchool(cursor.getString(3));

                studentList.add(student);

            }while (cursor.moveToNext());
        }
        return studentList;
    }

    public int getCount()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String statement = "SELECT * FROM students";
        Cursor cursor = db.rawQuery(statement,null);

        return cursor.getCount();
    }

}
