package com.example.sqlitedatabasetesting;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button update, insert,delete,showDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatabaseHandler databaseHandler = new DatabaseHandler(this);

        insert = findViewById(R.id.insert_contact);
        update = findViewById(R.id.update_contact);
        delete = findViewById(R.id.delete_contact);
        showDatabase = findViewById(R.id.database_contact);


        // Inserting Contacts
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent insertDataIntent = new Intent(MainActivity.this,InsertDataActivity.class);
                startActivity(insertDataIntent);



            }


        });


        //updating contacts
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateDatabase = new Intent(MainActivity.this,UpdateDatabase.class);
                startActivity(updateDatabase);

            }
        });


       //deleting contacts
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent deleteDatabase = new Intent(MainActivity.this,DeleteDatabase.class);
                startActivity(deleteDatabase);





            }
        });



        //showing databse
        showDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showdatabaseIntent = new Intent(MainActivity.this,ResultDatabase.class);
                startActivity(showdatabaseIntent);
            }
        });



        HashMap<String,String> names = databaseHandler.getALlnames();

        if(names.containsValue("Kaushal") && names.containsValue("1")){
            Toast.makeText(this, "KAUSHAL present", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "not present", Toast.LENGTH_SHORT).show();
        }
    }
}
