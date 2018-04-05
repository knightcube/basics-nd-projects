package com.knightcube.samples.travelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<TourItem> menuOptions = new ArrayList<TourItem>();
        menuOptions.add(new TourItem(getString(R.string.hotel_1_name), getString(R.string.hotel_1_address), R.drawable.the_oberoi, getString(R.string.hotel_1_description)));
        menuOptions.add(new TourItem(getString(R.string.hotel_2_name),getString(R.string.hotel_2_address),R.drawable.itc_sonar,getString(R.string.hotel_2_description)));
        menuOptions.add(new TourItem(getString(R.string.hotel_3_name),getString(R.string.hotel_3_address),R.drawable.swissotel,getString(R.string.hotel_3_description)));
        menuOptions.add(new TourItem(getString(R.string.hotel_4_name),getString(R.string.hotel_4_address),R.drawable.taj_bengal,getString(R.string.hotel_4_description)));
        menuOptions.add(new TourItem(getString(R.string.hotel_5_name),getString(R.string.hotel_5_address),R.drawable.gateway_em_bypass,getString(R.string.hotel_5_description)));
        GeneralMenuAdapter generalMenuAdapter = new GeneralMenuAdapter(HotelsActivity.this, menuOptions);
        ListView menuOptionsListView = (ListView) findViewById(R.id.hotels_list_view);
        menuOptionsListView.setAdapter(generalMenuAdapter);
    }

}
