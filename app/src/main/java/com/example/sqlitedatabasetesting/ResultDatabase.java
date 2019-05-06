package com.example.sqlitedatabasetesting;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ResultDatabase extends AppCompatActivity {

    DatabaseHandler databaseHandler = new DatabaseHandler(this);
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
private List<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_database);

        recyclerView = findViewById(R.id.contacts_recycler_view);
        recyclerView.hasFixedSize();
        LinearLayoutManager linearLayout =new LinearLayoutManager(this);
       // linearLayout.setReverseLayout(true);
        linearLayout.setStackFromEnd(true);

        recyclerView.setLayoutManager(linearLayout);

         contacts = databaseHandler.getAllContacts() ;




    }

    @Override
    protected void onStart() {
        super.onStart();


        mAdapter = new MyAdapter(contacts);

          int size = contacts.size();

        recyclerView.setAdapter(mAdapter);
        //recyclerView.smoothScrollToPosition(size);
    }

    //adapter class
  public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<Contact> mcontacts;

        public MyAdapter(List<Contact> contacts) {
            this.mcontacts = contacts;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View listItem= layoutInflater.inflate(R.layout.single_contact, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {



            viewHolder.Name.setText(mcontacts.get(i).getName());
            viewHolder.PhoneNo.setText(mcontacts.get(i).getPhoneNumber());
            viewHolder.Id.setText(String.valueOf(mcontacts.get(i).getID()));
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ResultDatabase.this,"id" + String.valueOf(mcontacts.get(i).getID()), Toast.LENGTH_SHORT).show();
                }
            });


        }

        @Override
        public int getItemCount() {

            int n = databaseHandler.getContactsCount();
            return n;
        }
    }



//view Holder class
   public class ViewHolder extends RecyclerView.ViewHolder{

        View view;
       TextView Id;
        TextView Name;
        TextView PhoneNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;

            Name = view.findViewById(R.id.contact_name);
            Id = view.findViewById(R.id.contact_id);
            PhoneNo = view.findViewById(R.id.contact_phoneNo);
        }






}

}





