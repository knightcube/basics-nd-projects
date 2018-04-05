package com.knightcube.samples.travelguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("Fast Facts");
        menuOptions.add("Hotels");
        menuOptions.add("Restaurants");
        menuOptions.add("Places to visit");
        menuOptions.add("Shopping");
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(MainActivity.this, menuOptions, R.layout.main_list_view_item);
        ListView menuOptionsListView = (ListView) findViewById(R.id.list_view_menu_options);
        menuOptionsListView.setAdapter(mainMenuAdapter);
        menuOptionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {

                    case 0:
                        intent = new Intent(MainActivity.this, FastFactsActivity.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(MainActivity.this, HotelsActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, PlacesToVisitActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, ShoppingActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });

    }


}