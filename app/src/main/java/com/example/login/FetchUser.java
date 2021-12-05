package com.example.login;

import static com.example.login.Login.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class FetchUser extends AppCompatActivity {

    private AutoCompleteTextView empId;
    private EditText empName;
    private TextView empMail;
    private ConstraintLayout masterLayout;
    private String[] list;
    private String userName, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_user);

        masterLayout = findViewById(R.id.FetchUserMasterLayout);
        empId = findViewById(R.id.FetchUserEmplyeeID);
        empName = findViewById(R.id.FetchUserName);
        empMail = findViewById(R.id.FetchUserGoogleMailId);

        list = utils.usersMap.keySet().toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice, list);

        empId.setThreshold(5);
        empId.setAdapter(adapter);

        userName = utils.getUserName;
        userId = utils.getUserMailId;

        empName.setText(userName);
        empMail.setText(userId);

    }
}