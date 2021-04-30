package com.example.listviewwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Integer> id;
    private ArrayList<String> name;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listItemId);
        databaseHelper = new DatabaseHelper(this);
        loadData();
        customAdapter = new CustomAdapter(this,id,name);
        listView.setAdapter(customAdapter);
    }

    private void loadData(){
        Cursor cursor = databaseHelper.findData();
        id = new ArrayList<>();
        name = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                id.add(Integer.parseInt(cursor.getString(0)));
                name.add(cursor.getString(1));
            }
        }
    }
}