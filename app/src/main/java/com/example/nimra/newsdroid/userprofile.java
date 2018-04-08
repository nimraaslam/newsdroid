package com.example.nimra.newsdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userprofile extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView useremail;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, login.class));

        }

        FirebaseUser user  = firebaseAuth.getCurrentUser();

        logout = (Button) findViewById(R.id.logout);

        useremail = (TextView) findViewById(R.id.useremail);

        useremail.setText("Welcome "+user.getEmail());

        logout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view == logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login.class));
        }

    }
}
