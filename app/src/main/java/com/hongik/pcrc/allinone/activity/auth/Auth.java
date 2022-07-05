package com.hongik.pcrc.allinone.activity.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.hongik.pcrc.allinone.R;
import com.hongik.pcrc.allinone.fragment.auth.SignIn;
import com.hongik.pcrc.allinone.fragment.auth.SignUp;

public class Auth extends AppCompatActivity implements SignIn.Callbacks, SignUp.Callbacks {

    public static String TAG = "Auth";

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

    @Override
    public void onSignUpSelected() {
        Log.d(TAG,"AuthActivity.onSignUpSelected called");

        SignUp signUpFragemnt = SignUp.newInstance(null, null);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.auth_fragment_container, signUpFragemnt)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onResetPasswordSelected() {
        Log.d(TAG,"AuthActivity.onResetPasswordSelected called");
    }

    @Override
    public void onBackArrowSelected() {
        Log.d(TAG,"AuthActivity.onBackArrowSelected called");
        Fragment removeFragemnt = getSupportFragmentManager().findFragmentById(R.id.auth_fragment_container);
        getSupportFragmentManager()
                .beginTransaction()
                .remove(removeFragemnt)
                .commit();
        finish();
    }
}