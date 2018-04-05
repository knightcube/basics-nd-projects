package com.knightcube.samples.travelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<TourItem> menuOptions = new ArrayList<TourItem>();
        menuOptions.add(new TourItem(getString(R.string.shopping_1_name), getString(R.string.shopping_1_address), R.drawable.quest_mall, getString(R.string.shopping_1_description)));
        menuOptions.add(new TourItem(getString(R.string.shopping_2_name), getString(R.string.shopping_2_address), R.drawable.new_market, getString(R.string.shopping_2_description)));
        menuOptions.add(new TourItem(getString(R.string.shopping_3_name), getString(R.string.shopping_3_address), R.drawable.college_street, getString(R.string.shopping_3_description)));
        menuOptions.add(new TourItem(getString(R.string.shopping_4_name), getString(R.string.shopping_4_address), R.drawable.gangurams, getString(R.string.shopping_4_description)));
        GeneralMenuAdapter generalMenuAdapter = new GeneralMenuAdapter(ShoppingActivity.this, menuOptions);
        ListView menuOptionsGridView = (ListView) findViewById(R.id.shopping_list_view);
        menuOptionsGridView.setAdapter(generalMenuAdapter);
    }

}
