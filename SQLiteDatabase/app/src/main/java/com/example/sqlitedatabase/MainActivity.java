package com.example.sqlitedatabase;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etPhone;
    private TextView tvName;
    private TextView tvPhone;
    private Button add;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();

        add.setOnClickListener(this);

//        final String SHARED_NAME = "shared";
//        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
//        sharedPref.edit().putBoolean("logined", true).apply();
//        sharedPref.getBoolean("logined", false);


        db = new DBHelper(getApplicationContext());

        // update inserted contact
//        db.updateContact(contact);

        // get all contacts
//        db.getAllContacts();

        // get contact at ID
//        db.getContact(0);

        // get contacts all count
//        db.getContactsCount();

        // upgrade db required SQLite database, old version, new version
//        db.onUpgrade();

        // delete contact
//        db.deleteContact(contact);

        // Reading all contacts


//        for (Contact cn : contacts) {
//            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            Log.i("Name: ", log);
//        }
    }

    private void findViewById() {
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);
        add = findViewById(R.id.btn_add);
    }

    private void getContacts(DBHelper db) {
        ArrayList<Contact> contacts = db.getAllContacts();

        setData(contacts);
    }

    private void setData(ArrayList<Contact> contacts) {
        if (contacts.size() > 0) {
            tvName.setText(contacts.get(contacts.size() - 1).name);
            tvPhone.setText(contacts.get(contacts.size() - 1).phone_number);
        }
    }

    @Override
    public void onClick(View v) {
        // insert new contact

        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();

        Contact contact = new Contact(name, phone);
        db.addContact(contact);

        getContacts(db);
    }
}