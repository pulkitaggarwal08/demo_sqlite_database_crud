package com.demo_sqlite_crud.pulkit.models;

/**
 * Created by Tulshiram on 11/18/2015.
 */
public class Student
{
    private int student_Rollno;
    private String student_Name;
    private String student_Phone;

    public Student()
    {

    }

    public Student(int student_Rollno, String student_Name, String student_Phone)
    {
        this.student_Rollno=student_Rollno;
        this.student_Name=student_Name;
        this.student_Phone=student_Phone;
    }


    public int getStudent_Rollno() {
        return student_Rollno;
    }

    public void setStudent_Rollno(int student_Rollno) {
        this.student_Rollno = student_Rollno;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_Phone() {
        return student_Phone;
    }

    public void setStudent_Phone(String student_Phone) {
        this.student_Phone = student_Phone;
    }

}
