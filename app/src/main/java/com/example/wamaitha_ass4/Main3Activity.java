package com.example.wamaitha_ass4;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Main3Activity extends AppCompatActivity {
    private EditText fname, lname, username, password,domain,account,description;
    private Button registerButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        domain = findViewById(R.id.domain);
        account = findViewById(R.id.account);
        description = findViewById(R.id.description);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("wamaitha_Ass4");

                //get all the values from the text fields
                String strfname = fname.getText().toString();
                String strlname = lname.getText().toString();
                String strusername = username.getText().toString();
                String strpassword = password.getText().toString();
                String strdomain = domain.getText().toString();
                String straccount = account.getText().toString();
                String strdescription = description.getText().toString();

                UserHelperClass helper = new UserHelperClass(strfname,strlname,strusername,strpassword,strdomain,straccount, strdescription);



                //push values into users
                //reference.setValue(helper);
                reference.child(strusername).setValue(helper);
                Toast.makeText(Main3Activity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
