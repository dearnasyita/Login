package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class SplashScreenActivity extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate (savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(isLogin()){
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                    finish();
                }
            }, 3000);
        }

    boolean isLogin(){
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if(file.exists()){
            return true;
        } else {
            return false;
        }
    }
}

