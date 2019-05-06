package com.example.sqlitedatabasetesting;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateDatabase extends AppCompatActivity {

    private EditText name,number,m_id;
    private Button Updatebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_database);

        m_id = findViewById(R.id.update_id);
        name = findViewById(R.id.update_name);
        number = findViewById(R.id.update_phoneNO);
        Updatebtn = findViewById(R.id.update_btn);
        final DatabaseHandler databaseHandler = new DatabaseHandler(this);



        Updatebtn.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {

                final String uid = m_id.getText().toString();
                final String Username = name.getText().toString();
                final String PhoneNo = number.getText().toString();

                if(!TextUtils.isEmpty(Username)&& !TextUtils.isEmpty(PhoneNo) && !TextUtils.isEmpty(uid)){


                Contact contact = databaseHandler.getContact(Integer.parseInt(uid));
                contact.setName(Username);
                contact.setPhoneNumber(PhoneNo);
                 databaseHandler.updateContact(contact);

                // Reading all contacts
                Log.d("Reading: ", "in Updating contacts..");
                List<Contact> contacts = databaseHandler.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);
                }

                Toast.makeText(UpdateDatabase.this, "Database Updated: ", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(UpdateDatabase.this, "Please fill the Complete Form", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
