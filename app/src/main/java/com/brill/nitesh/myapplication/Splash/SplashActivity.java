package com.brill.nitesh.myapplication.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.brill.nitesh.myapplication.Activity.HomeActivity;
import com.brill.nitesh.myapplication.R;

import net.bohush.geometricprogressview.GeometricProgressView;
import net.bohush.geometricprogressview.TYPE;

public class SplashActivity extends AppCompatActivity {

    private ConstraintLayout main_layout;
    private ImageView imageView;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        main_layout = (ConstraintLayout) findViewById(R.id.main_layout);

        imageView = (ImageView) findViewById(R.id.imageView);
        setAnimation();
    }

    private void setAnimation() {


        mAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        mAnimation.reset();
        main_layout.clearAnimation();
        main_layout.setAnimation(mAnimation);

        mAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        mAnimation.reset();
        imageView.clearAnimation();
        imageView.setAnimation(mAnimation);

        Log.e(" Animation ", "=====" + mAnimation.getDuration());

        //mAnimation.getDuration();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                GeometricProgressView progressView = (GeometricProgressView) findViewById(R.id.progressView);
                progressView.setVisibility(View.VISIBLE);
                progressView.setType(TYPE.KITE);
                progressView.setNumberOfAngles(6);
                //  progressView.setColor(Color.parseColor("#00897b"));
                progressView.setDuration(1000);

            }
        }, 3000);

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                try {

                    Thread.sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                }
            }
        };
        thread.start();


    }


}
