package com.cst2335.inclassexamples_w21;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button previousButton = findViewById(R.id.previousPageButton);

        previousButton.setOnClickListener(click ->
                finish()
        );

    }
}
