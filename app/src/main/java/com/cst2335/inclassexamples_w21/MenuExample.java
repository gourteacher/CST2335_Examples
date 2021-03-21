package com.cst2335.inclassexamples_w21;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

public class MenuExample extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_example);

            //This gets the toolbar from the layout:
            Toolbar tBar = findViewById(R.id.toolbar);

            //This loads the toolbar, which calls onCreateOptionsMenu below:
            setSupportActionBar(tBar);

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu items for use in the action bar
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.example_menu, menu);

            MenuItem shareItem =  menu.findItem(R.id.share);
            shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
            setIntent("Example share text");

            MenuItem searchItem = menu.findItem(R.id.search_item);
            SearchView sView = (SearchView)searchItem.getActionView();
            sView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String q) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String message = null;
            //Look at your menu XML file. Put a case for every id in that file:
            switch(item.getItemId())
            {
                //what to do when the menu item is selected:
                case R.id.share:
                    message = "You clicked share";
                    break;
                case R.id.search_item:
                    message = "You clicked on the search";
                    break;
                case R.id.help_item:
                    message = "You clicked on help";
                    break;
                case R.id.mail:
                    message = "You clicked on mail";
                    break;
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            return true;
        }

        private void setIntent(String t) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, t);
            shareActionProvider.setShareIntent(i);

        }

    }



