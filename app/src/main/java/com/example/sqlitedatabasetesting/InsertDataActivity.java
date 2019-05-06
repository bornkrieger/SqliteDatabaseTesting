package com.example.sqlitedatabasetesting;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InsertDataActivity extends AppCompatActivity {

    private EditText name,number;
    private Button Addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        name = findViewById(R.id.name);
        number = findViewById(R.id.phoneNO);
        Addbtn = findViewById(R.id.add_contact);



       final DatabaseHandler databaseHandler = new DatabaseHandler(this);

        Addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Username = name.getText().toString();
                final String PhoneNo = number.getText().toString();


                if(!TextUtils.isEmpty(Username)&& !TextUtils.isEmpty(PhoneNo)){

                Log.d("Insert: ", "Inserting ..");
                databaseHandler.addContact(new Contact(Username, PhoneNo));

                Toast.makeText(InsertDataActivity.this, "Added to Database", Toast.LENGTH_SHORT).show();


                // Reading all contacts
                Log.d("Reading: ", "in Inserting Contacts..");
                List<Contact> contacts = databaseHandler.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);

                }


                }else
                    {
                        Toast.makeText(InsertDataActivity.this, "Please Fill Complete Form", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
