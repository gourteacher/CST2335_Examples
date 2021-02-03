package com.cst2335examples.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String CAT = "MainActivity";

    Boolean isRunning = false;
    long offset = 0;
    Chronometer stopwatch;

    private static final String OFFSET_KEY = "offset";
    private static final String RUNNING_KEY = "running";
    private static final String BASE_KEY = "base";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i( CAT , "onCreate()");

        setContentView(R.layout.activity_main);

        isRunning = false;
        offset = 0;

        if (savedInstanceState != null) {
            offset = savedInstanceState.getLong(OFFSET_KEY);
            isRunning = savedInstanceState.getBoolean(RUNNING_KEY);
            if (isRunning) {
                stopwatch.setBase(savedInstanceState.getLong (BASE_KEY ) );
            } else {
                setBaseTime();
            }
        }
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong(OFFSET_KEY, offset);
        outState.putBoolean(RUNNING_KEY,  isRunning);
        outState.putLong(BASE_KEY, stopwatch.getBase());

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i( CAT ,  "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i( CAT ,  "onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i( CAT ,  "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i( CAT , "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i( CAT , "onDestroy()");
    }
}