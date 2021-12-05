package com.example.login;

import com.google.firebase.database.FirebaseDatabase;

public class persistClass extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
