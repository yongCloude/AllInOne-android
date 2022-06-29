package com.hongik.pcrc.allinone.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.hongik.pcrc.allinone.R;
import com.hongik.pcrc.allinone.fragment.auth.SignIn;

public class Auth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.auth_fragment_container);
        if(currentFragment == null){
            SignIn fragment = new SignIn();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.auth_fragment_container, fragment)
                    .commit();
        }

    }
}