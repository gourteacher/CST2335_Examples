package com.cst2335.inclassexamples_w21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.PersistableBundle;


public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Your program starts here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.userInput);

        //use a Lambda function to set a click listener
        Button page2Button = (Button) findViewById(R.id.firstButton);
        if (page2Button != null) {
            page2Button.setOnClickListener(clk -> {
                Intent goToPage2 = new Intent(FirstActivity.this, SecondActivity.class);

                goToPage2.putExtra("name", "me");
                goToPage2.putExtra("age", 20);
                goToPage2.putExtra("typed", editText.getText().toString());

                startActivityForResult(goToPage2, 30);
            });
        }

            Button saveButton = findViewById(R.id.saveButton);
            if (saveButton != null)
                saveButton.setOnClickListener(v -> {

                });
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState){
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30) //you went to page 2
        {
            if (resultCode == 50) //you hit the finish button
            {
                Toast.makeText(this, "You came back from page 3 by hitting the finish button",
                        Toast.LENGTH_LONG).show();
            }
            else if (resultCode == RESULT_CANCELED) //you hit the back button
            {
                   Toast.makeText(this, "You came back from page 3 by hitting the back button",
                                Toast.LENGTH_SHORT).show();
            }
        }
    }
}
