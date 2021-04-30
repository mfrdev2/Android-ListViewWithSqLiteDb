package com.example.listviewwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText idEditText,nameEditText;
    private Button saveButton,loadButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idEditText = findViewById(R.id.idEditTextId);
        nameEditText = findViewById(R.id.nameEditTextId);
        saveButton = findViewById(R.id.saveButtonId);
        loadButton = findViewById(R.id.loadButtonId);
        databaseHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String id = idEditText.getText().toString().trim();
        String name = nameEditText.getText().toString();
        if(id.equals("")){
            id = "0";
        }
        int idInt = Integer.parseInt(id);
        final Boolean b = (!(idInt <1) && !name.equals(""));
        if(v.getId() == R.id.saveButtonId){
            if(b){
                Student student = new Student(idInt,name);
                long rawId = databaseHelper.insertData(student);
                if(rawId>0){
                    Toast.makeText(this,"Data is inserted",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this,"Something Wrong!",Toast.LENGTH_LONG).show();
                }
            }

        }
        if(v.getId() == R.id.loadButtonId){
            Intent intent = new Intent(getBaseContext(),ListViewActivity.class);
            startActivity(intent);
        }

    }
}