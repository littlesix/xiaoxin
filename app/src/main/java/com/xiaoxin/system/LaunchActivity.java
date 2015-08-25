package com.xiaoxin.system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xiaoxin.R;
import com.xiaoxin.basic.login.view.LoginActivity;


public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

    }


    public void ss(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
