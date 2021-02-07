package com.cst2335examples.w21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


import androidx.appcompat.app.AppCompatActivity;


public class FirstActivity extends AppCompatActivity {
    private ArrayList<String> elements = new ArrayList<>( Arrays.asList( "One", "Two", "Three" ) );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Your program starts here
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);



        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener( click -> {
            elements.add("Hi");
        });

    }


}
