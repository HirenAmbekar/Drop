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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

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
