package com.example.wamaitha_ass4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main2Activity extends AppCompatActivity {
    public static final String EXTRA_USERNAME = "com.example.wamaitha_ass4.EXTRA_NAME";
    private TextView fname, lname, username, password,domain,account,description;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        domain = findViewById(R.id.domain);
        account = findViewById(R.id.account);
        description = findViewById(R.id.description);
        Intent intent = getIntent();
        String s1 = intent.getStringExtra(MainActivity.EXTRA_USERNAME);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("wamaitha_Ass4").child(s1);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strfname = dataSnapshot.child("fname").getValue().toString();
                String strlname = dataSnapshot.child("lname").getValue().toString();
                String strusername = dataSnapshot.child("username").getValue().toString();
                String strpassword = dataSnapshot.child("password").getValue().toString();
                String strdomain = dataSnapshot.child("domain").getValue().toString();
                String straccount = dataSnapshot.child("account").getValue().toString();
                String strdescription = dataSnapshot.child("description").getValue().toString();

                fname.setText(strfname);
                lname.setText(strlname);
                username.setText(strusername);
                password.setText(strpassword);
                domain.setText(strdomain);
                account.setText(straccount);
                description.setText(strdescription);


                Toast.makeText(Main2Activity.this, "Now showing values", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Main2Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
