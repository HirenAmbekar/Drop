package com.example.drop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView lightwave;
    ImageView darkwave;
    ImageView droplogo;
    TextView droptext;
    Button startedbutton;
    Animation frombottom;
    Animation fadein;
    Animation fadein2;

    SharedPreferences sharedPreferences;
    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_splash_screen);

        sharedPreferences = getSharedPreferences("myPreference", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime", true);

        lightwave = (ImageView) findViewById(R.id.lightwave);
        darkwave = (ImageView) findViewById(R.id.darkwave);
        droplogo = (ImageView) findViewById(R.id.droplogo);
        droptext = (TextView) findViewById(R.id.droptext);
        startedbutton = (Button) findViewById(R.id.startedbutton);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.formbottom);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadein2 = AnimationUtils.loadAnimation(this, R.anim.fadein2);

        lightwave.setAnimation(frombottom);
        darkwave.setAnimation(frombottom);

        droplogo.setAnimation(fadein);
        droptext.setAnimation(fadein);
        startedbutton.setAnimation(fadein2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime", firstTime);
                    editor.apply();

                    Intent intent = new Intent(SplashScreenActivity.this, WelcomeActivity1.class);
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                }
                else {
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    SplashScreenActivity.this.finish();
                }
            }
        },10000);



    }

    public void startLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        SplashScreenActivity.this.finish();
    }
}
