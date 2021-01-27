package com.cst2335.inclassexamples_w21;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrebuiltIntentExamples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prebuilt_intent_examples);

        //This shows how to use Android's default email app to send an email:
        Button temp = findViewById(R.id.sendEmailExample);
        temp.setOnClickListener(click ->{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"email@example.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
            intent.putExtra(Intent.EXTRA_TEXT, "body text");
            startActivity(intent);

        });

        //This shows how to use Android's default web view app to view a web page:
        temp = findViewById(R.id.viewURL);
        temp.setOnClickListener( click -> {

            String url = "http://www.algonquincollege.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData( Uri.parse(url) );
            startActivity(i);

        });

        //This shows how to use Android's default web view app to view a web page:
        temp = findViewById(R.id.makePhoneCall);
        temp.setOnClickListener( click -> {

            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData( Uri.parse("tel:" + "6137274723") );
            startActivity(i);

        });
    }
}
