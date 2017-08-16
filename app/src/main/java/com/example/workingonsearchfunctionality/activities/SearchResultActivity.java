package com.example.workingonsearchfunctionality.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workingonsearchfunctionality.R;
import com.example.workingonsearchfunctionality.database.DatabaseTable;

public class SearchResultActivity extends AppCompatActivity
{
    DatabaseTable db = new DatabaseTable(this);
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        textView = (TextView) findViewById(R.id.text);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent)
    {
        if(Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = db.getWordMatches(query, null);
            String result = "";
            //process Cursor and display results
            if( cursor != null && cursor.moveToFirst() )
            {
                do
                {
                    String word = cursor.getString(0);
                    String definition = cursor.getString(1);
                    result = result + word+" : "+definition+" \n--------------\n";
                }while(cursor.moveToNext());
                cursor.close();
            }

            textView.setText(result);
        }
    }

}
