package com.example.mydatabase;

public class Student {
    private String name;
   private String department;
   private String School;
   private int id;


    public Student() {
    }

    public Student(String name, String department, String school,int id) {
        this.name = name;
        this.department = department;
        School = school;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
    public void setId(int id){
        this.id = id;

    }

    public int getId(){
        return id;
    }
}
