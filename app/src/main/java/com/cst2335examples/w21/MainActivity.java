package com.cst2335examples.w21;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    EditText search;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText)findViewById(R.id.searchBar);
        result = (TextView) findViewById(R.id.result);

        Button addButton = findViewById(R.id.fetchItem);
        addButton.setOnClickListener( click -> {
            String currency = search.getText().toString();
            String queryURL = "https://api.exchangeratesapi.io/latest?base=USD";
            String[] myTaskParams = { queryURL, currency };
            MyNetworkQuery theQuery = new MyNetworkQuery();
            theQuery.execute(myTaskParams );
        });
    }

    //                                      Type1, Type2   Type3
    private class MyNetworkQuery extends AsyncTask<String, String, String>{

        @Override                       //Type 1
        protected String doInBackground(String ... strings) {
            String res = null;

            //default values
            String cur = "CAD";
            String queryURL=  "https://api.exchangeratesapi.io/latest?base=USD";

            if (strings.length > 1 && strings[1].length() > 2) {
                cur = strings[1];
            }

            if (strings.length > 0 && strings[0].length() > 16) {
                queryURL = strings[0];
            }


            try {

                UrlFetcher url = new UrlFetcher();
                String rate = url.fetchItems(queryURL, cur);

                res =  "Rate for " + cur + " : " + rate ;
            }
            catch (Exception e)
            {
                res = "Failed to fetch items from URL";
            }
            //What is returned here will be passed as a parameter to onPostExecute:
            return res;
        }

        @Override                   //Type 3
        protected void onPostExecute(String sentFromDoInBackground) {
            super.onPostExecute("Finished background thread");
            //update GUI Stuff:
            if (sentFromDoInBackground != null ) {
                result.setText(sentFromDoInBackground);
            } else {
                result.setText("Finished background thread with an unknown error");
            }
        }

        @Override                       //Type 2
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }
    }
}