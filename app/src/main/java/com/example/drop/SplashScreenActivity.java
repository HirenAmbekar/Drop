package com.example.drop;

import android.content.Intent;
import android.os.Bundle;
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


    }

    public void startLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        SplashScreenActivity.this.finish();
    }
}
