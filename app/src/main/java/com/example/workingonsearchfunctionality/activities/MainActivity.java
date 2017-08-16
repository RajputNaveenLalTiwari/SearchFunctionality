package com.example.workingonsearchfunctionality.activities;


import android.app.SearchManager;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.workingonsearchfunctionality.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.appBarID);
        toolBar.setMinimumHeight(toolBar.getHeight());
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        getSupportActionBar().setTitle(R.string.app_name);
        toolBar.setNavigationOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
//        {
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//            SearchView searchView = (SearchView) menu.findItem(R.id.searchID).getActionView();
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.searchID));
            if(searchView!=null)
            {
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
            }
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        }
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.appBarID:
                finish();
                break;
        }
    }
}
