package com.example.assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHandler extends SQLiteOpenHelper{
    private static final String DB_NAME = "assignmentdb";
    private static final String TABLE_NAME = "userdetails";
    private static final String NAME_COL = "Name";
    private static final String DOB_COL = "DOB";
    private static final String EMAIL_COL = "Email";
    private static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + NAME_COL + "TEXT,"
                + DOB_COL + "TEXT,"
                + EMAIL_COL + "TEXT)";
        db.execSQL(query);
    }

    public void submitbtn(EditText Name, EditText Date, EditText Email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, String.valueOf(Name));
        values.put(DOB_COL, String.valueOf(Date));
        values.put(EMAIL_COL, String.valueOf(Email));
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
