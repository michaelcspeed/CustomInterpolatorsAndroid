package com.example.speedm01.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean swap;
    private boolean swap1;
    private int anInt = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap = !swap;
                button.animate().scaleXBy(swap ? anInt : -anInt).scaleYBy(swap ? anInt : -anInt)
                        .setInterpolator(new SettleInterpolator(.2f, 0.6f));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swap1 = !swap1;
                button2.animate().scaleXBy(swap1 ? anInt : -anInt).scaleYBy(swap1 ? anInt : -anInt)
                        .setInterpolator(new OvershootInterpolator());

            }
        });

    }
}
