package com.demo_sqlite_crud.pulkit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by param on 2/04/2016.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_School = "school";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_ROLLNUMBER = "studentrollno";
    public static final String COLUMN_STUDENT_NAME = "studentname";
    public static final String COLUMN_STUDENT_PHONE = "studentphone";
    public static final String COLUMN_STUDENT_EMAIL = "studentemail";

    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE " + TABLE_STUDENT + "(" +
            COLUMN_STUDENT_ROLLNUMBER + " INTEGER PRIMARY KEY," +
            COLUMN_STUDENT_NAME + " TEXT," +
            COLUMN_STUDENT_PHONE + " TEXT," +
            COLUMN_STUDENT_EMAIL + " TEXT);";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_School, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

}
