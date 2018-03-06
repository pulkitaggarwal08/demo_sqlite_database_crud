package com.demo_sqlite_crud.pulkit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.demo_sqlite_crud.pulkit.models.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLController {

    private SQLiteDatabase sqLiteDatabase;
    private DataBaseHandler dataBaseHandler;
    private Context context;

    public SQLController(Context context) {
        this.context = context;
        dataBaseHandler = new DataBaseHandler(context);
    }

    public SQLController open() throws SQLException {
        sqLiteDatabase = dataBaseHandler.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHandler.close();
    }

    public void addStudent(int student_Rollno, String student_Name, String student_Phone) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHandler.COLUMN_STUDENT_ROLLNUMBER, student_Rollno);
        contentValues.put(DataBaseHandler.COLUMN_STUDENT_NAME, student_Name);
        contentValues.put(DataBaseHandler.COLUMN_STUDENT_PHONE, student_Phone);

        sqLiteDatabase.insert(DataBaseHandler.TABLE_STUDENT, null, contentValues);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<Student>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DataBaseHandler.TABLE_STUDENT, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setStudent_Rollno(Integer.parseInt(cursor.getString(0)));
                student.setStudent_Name(cursor.getString(1));
                student.setStudent_Phone(cursor.getString(2));

                list.add(student);

            }
            while (cursor.moveToNext());
        }
        return list;
    }

    public int updateStudent(int roll, String student_Name, String student_Phone) {

        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.COLUMN_STUDENT_NAME, student_Name);
        values.put(DataBaseHandler.COLUMN_STUDENT_PHONE, student_Phone);

        // updating row
        return sqLiteDatabase.update(DataBaseHandler.TABLE_STUDENT, values, DataBaseHandler.COLUMN_STUDENT_ROLLNUMBER + " = ?", new String[]{String.valueOf(roll)});
    }

    public void deleteStudent(int roll) {
        sqLiteDatabase.delete(DataBaseHandler.TABLE_STUDENT, DataBaseHandler.COLUMN_STUDENT_ROLLNUMBER + "= ?", new String[]{String.valueOf(roll)});
    }

//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_STUDENT;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }

}
