package com.example.practise_again;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "employee_database";
    //Database Table name
    private static final String TABLE_NAME = "EMPLOYEE";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL," + EMAIL + " TEXT NOT NULL);";

    //constructor
    public Dao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Employee Data insert
    public void addEmployee(Bean bean) {
        ContentValues cv = new ContentValues();
        cv.put(Dao.NAME, bean.getName());
        cv.put(Dao.EMAIL, bean.getEmail());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(Dao.TABLE_NAME, null, cv);
    }

    // Select
    public List<Bean> getEmployeeList() {
        String sql = "Select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<Bean> storeEmployee = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                storeEmployee.add(new Bean(id, name, email));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeEmployee;
    }

    // Update
    public void updateEmployee(Bean bean) {
        ContentValues cv = new ContentValues();
        cv.put(Dao.NAME, bean.getName());
        cv.put(Dao.EMAIL, bean.getEmail());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME, cv,ID + " = ?", new String[]
                {String.valueOf(bean.getId())});
    }

    // Delete
    public void deleteEmployee(int id) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, id + " = ? ", new String[]
                {String.valueOf(id)});
    }
}
