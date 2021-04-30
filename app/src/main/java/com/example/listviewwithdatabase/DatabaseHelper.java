package com.example.listviewwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentID.db";
    private static final String TABLE_NAME = "Student";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private Context context;

    //QUERY
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ " ( "+
            ID +" INTEGER NOT NULL , "+ NAME+ " VARCHAR(100) NOT NULL);";
    private static final String TABLE_DATA = "SELECT * FROM "+TABLE_NAME;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertData(Student data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,data.getId());
        contentValues.put(NAME,data.getName());
       long rawId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       return rawId;
    }

    public Cursor findData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(TABLE_DATA,null);
        return cursor;
    }
}
