package com.example.login.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.login.FetchUser;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class JavaUtil {

    public static GoogleSignInAccount mAccount;
    public static FirebaseUser mUser;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference();

    public static Map<String, Object> usersMap;
    public static String getUserName;
    public static String getUserMailId;
    public static String getUserUid;
    public static Uri getUserImageId;

    public static void FetchUsers(Context context){
        myRef.child("employee_details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usersMap = (Map<String, Object>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(context, "Error reading database context", Toast.LENGTH_SHORT).show();
            }
        });

        myRef.keepSynced(true);
    }

    public void FetchGoogleInstance(Context context) {
        mAccount = GoogleSignIn.getLastSignedInAccount(context);
        if(mAccount != null) {
            getUserName = mAccount.getDisplayName();
            getUserMailId = mAccount.getEmail();
            getUserUid = mAccount.getId();
            getUserImageId = mAccount.getPhotoUrl();
        } else {
            Toast.makeText(context, "Error reading google context", Toast.LENGTH_SHORT).show();
        }
    }
}
