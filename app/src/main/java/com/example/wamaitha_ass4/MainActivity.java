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


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "com.example.wamaitha_ass4.EXTRA_ID";
    public static final String EXTRA_PASSWORD = "com.example.wamaitha_ass4.EXTRA_NAME";


    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private EditText username,password;
    private Button registerButton, loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity2();
            }
        });



        registerButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity3();

            Toast.makeText(MainActivity.this, "Going to register activity", Toast.LENGTH_SHORT).show();
        }
    });
    }

    public void openActivity3(){
        Intent intent= new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }
    public void OpenActivity2(){
       String strusername = username.getText().toString().trim();
       rootNode = FirebaseDatabase.getInstance();

//       gets username
       reference = rootNode.getReference("wamaitha_Ass4").child(strusername);
//check if the password given is same as in db
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String strpassword = password.getText().toString().trim();
                String strusername = username.getText().toString().trim();

                String getPasswordFromDb = dataSnapshot.child("password").getValue().toString();

//                if the passwords match go to activity 2
                if(getPasswordFromDb.equals(strpassword)){
                    Toast.makeText(MainActivity.this, "logging you in", Toast.LENGTH_SHORT).show();
                     Intent intent= new Intent(getApplicationContext(),Main2Activity.class);

                    intent.putExtra(EXTRA_USERNAME, strusername);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "That user doesnot exist", Toast.LENGTH_SHORT).show();
                OpenActivity2();

            }
        });

    }

}
