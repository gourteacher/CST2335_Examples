package com.cst2335examples.w21;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class ShowItemActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.fragment_2);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String selectedItem = extras.getString("item");
            TextView textView = findViewById(R.id.selectedopt);
            textView.setText("You have selected "+selectedItem);
        }
    }
}