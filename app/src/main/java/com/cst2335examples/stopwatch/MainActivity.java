package com.cst2335examples.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";

    Boolean isRunning = false;
    long offset = 0;
    Chronometer stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println( TAG + "onCreate()");

        setContentView(R.layout.activity_main);

        stopwatch =  findViewById(R.id.stopwatch);
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener ( clk ->  {
            if (!isRunning) {
                setBaseTime();
                stopwatch.start();
                isRunning = true;
            }
        });

        Button stopButton = findViewById(R.id.stopButton);
        stopButton.setOnClickListener ( clk ->  {
            if (isRunning) {
                saveOffset();
                stopwatch.stop();
                isRunning = false;
            }
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener ( clk ->  {
            offset = 0;
            setBaseTime();
        });
    }



    void setBaseTime() {
        stopwatch.setBase(SystemClock.elapsedRealtime() - offset);
    }

    void saveOffset() {
        offset = SystemClock.elapsedRealtime() - stopwatch.getBase();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println( TAG + "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println( TAG + "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println( TAG + "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println( TAG + "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println( TAG + "onDestroy()");
    }
}