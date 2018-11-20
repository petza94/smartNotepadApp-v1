package com.example.root.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.root.myapplication.user_sign.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private Button btnReg,btnLog;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnReg = (Button) findViewById(R.id.signup_btn);
        btnLog = (Button) findViewById(R.id.login_btn);

        fAuth = FirebaseAuth.getInstance();

        updateUI();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();

            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();

            }
        });

    }

    private void signup(){

        Intent signIntent = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(signIntent);
    }

    private void login(){

    }

    private void updateUI(){
        if (fAuth.getCurrentUser() != null){
            Log.i("StartActivity","fAuth!=null");
        }else{
            Intent startIntent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(startIntent);
            finish();
            Log.i("StartActivity","fAuth!=null");
        }
    }

}
