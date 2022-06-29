package com.hongik.pcrc.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.hongik.pcrc.allinone.activity.auth.Auth;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MainActivity";


    private ImageButton profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile = findViewById(R.id.main_profile);

        profile.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Auth.class);
            startActivity(intent);
        });

    }


}