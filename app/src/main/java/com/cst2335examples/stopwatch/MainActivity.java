package com.cst2335examples.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    final String CAT = "MainActivity";

    Boolean isRunning = false;
    long offset = 0;
    Chronometer stopwatch;

    final String OFFSET_KEY = "offset";
    final String RUNNING_KEY = "running";
    final String BASE_KEY = "base";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println( CAT + "onCreate()");

        setContentView(R.layout.activity_main);

        isRunning = false;
        offset = 0;
        stopwatch =  findViewById(R.id.stopwatch);

        if (savedInstanceState != null) {
            offset = savedInstanceState.getLong(OFFSET_KEY);
            isRunning = savedInstanceState.getBoolean(RUNNING_KEY);
            if (isRunning) {
                stopwatch.setBase(savedInstanceState.getLong (BASE_KEY ) );
            } else {
                setBaseTime();
            }
        }

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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong(OFFSET_KEY, offset);
        outState.putBoolean(RUNNING_KEY,  isRunning);
        outState.putLong(BASE_KEY, stopwatch.getBase());

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println( CAT + "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println( CAT + "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println( CAT + "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println( CAT + "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println( CAT + "onDestroy()");
    }
}