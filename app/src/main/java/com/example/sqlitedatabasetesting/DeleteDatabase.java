package com.example.sqlitedatabasetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class DeleteDatabase extends AppCompatActivity {

    private EditText del_id;
    private Button del_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        final DatabaseHandler databaseHandler = new DatabaseHandler(this);


        del_id = findViewById(R.id.delete_text_id);
        del_btn = findViewById(R.id.delete_btn);

        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = del_id.getText().toString();


                if(!TextUtils.isEmpty(uid)){

                    Contact contact = databaseHandler.getContact(Integer.parseInt(uid));
                    databaseHandler.deleteContact(contact);
                    Toast.makeText(DeleteDatabase.this, "Deleted Contact", Toast.LENGTH_SHORT).show();

                    List<Contact> contacts = databaseHandler.getAllContacts();
                    for(Contact cn: contacts){
                        String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Name: ", log);



                    }

                }
                else{
                    Toast.makeText(DeleteDatabase.this, "Please fill complete form", Toast.LENGTH_SHORT).show();
                }




            }
        });




    }
}
