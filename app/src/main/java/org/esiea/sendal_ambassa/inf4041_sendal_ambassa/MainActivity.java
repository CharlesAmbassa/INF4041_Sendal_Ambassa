package org.esiea.sendal_ambassa.inf4041_sendal_ambassa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    ListView lvDetail;
    Context context = MainActivity.this;
    ArrayList myList = new ArrayList();

    String[] title = new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4",
            "Title 5", "Title 6", "Title 7", "Title 8"
    };
    String[] desc = new String[]{
            "Footballeur", "Boulanger", "Prof", "Musicien",
            "Avocat", "Chef de projet", "Secretaire", "Informaticien"
    };
    int[] img = new int[]{
            R.drawable.star1, R.drawable.star2, R.drawable.star3, R.drawable.star4,
            R.drawable.star5, R.drawable.star6, R.drawable.star7, R.drawable.star8
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDetail = (ListView) findViewById(R.id.lvCustomList);
        // insert data into the list before setting the adapter
        // otherwise it will generate NullPointerException  - Obviously
        getDataInList();
        lvDetail.setAdapter(new MyBaseAdapter(context, myList));
    }

    private void getDataInList() {
        for (int i = 0; i < title.length; i++)
        {
            // Create a new object for each list item
            ListData ld = new ListData();
            ld.setTitle(title[i]);
            ld.setDescription(desc[i]);
            ld.setImgResId(img[i]);
            // Add this object into the ArrayList myList
            myList.add(ld);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_Setting) {
            // When Setting Key is pressed
            Toast.makeText(getApplicationContext(), "Aucun réglage pour l'instant", Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menu_help) {
            // When Setting Key is pressed
            Toast.makeText(getApplicationContext(), "Besoin d'aide ? va voir les resto du coeur enfoiré", Toast.LENGTH_LONG).show();
        }
        return true;

    }

}


