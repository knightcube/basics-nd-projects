package com.knightcube.samples.travelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<TourItem> menuOptions = new ArrayList<TourItem>();
        menuOptions.add(new TourItem(getString(R.string.restaurant_1_name), getString(R.string.restaurant_1_address), R.drawable.bhojohori_manna, getString(R.string.restaurant_1_description)));
        menuOptions.add(new TourItem(getString(R.string.restaurant_2_name), getString(R.string.restaurant_2_address), R.drawable.the_royal_bengal_tiger_cafe, getString(R.string.restaurant_2_description)));
        menuOptions.add(new TourItem(getString(R.string.restaurant_3_name), getString(R.string.restaurant_3_address), R.drawable.rang_de_basanti_dhaba, getString(R.string.restaurant_3_description)));
        menuOptions.add(new TourItem(getString(R.string.restaurant_4_name), getString(R.string.restaurant_4_address), R.drawable.piccadilly_square, getString(R.string.restaurant_4_description)));
        menuOptions.add(new TourItem(getString(R.string.restaurant_5_name), getString(R.string.restaurant_5_address), R.drawable.flurys, getString(R.string.restaurant_5_description)));
        GeneralMenuAdapter generalMenuAdapter = new GeneralMenuAdapter(RestaurantsActivity.this, menuOptions);
        ListView menuOptionsListView = (ListView) findViewById(R.id.restaurants_list_view);
        menuOptionsListView.setAdapter(generalMenuAdapter);
    }

}
