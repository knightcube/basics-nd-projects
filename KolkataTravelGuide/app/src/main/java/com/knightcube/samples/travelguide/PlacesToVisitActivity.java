package com.knightcube.samples.travelguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesToVisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<TourItem> menuOptions = new ArrayList<TourItem>();
        menuOptions.add(new TourItem(getString(R.string.places_to_visit_1_name), getString(R.string.places_to_visit_1_address), R.drawable.national_library, getString(R.string.places_to_visit_1_description)));
        menuOptions.add(new TourItem(getString(R.string.places_to_visit_2_name), getString(R.string.places_to_visit_2_address), R.drawable.mandarmani, getString(R.string.places_to_visit_2_description)));
        menuOptions.add(new TourItem(getString(R.string.places_to_visit_3_name), getString(R.string.places_to_visit_3_address), R.drawable.victoria_memorial, getString(R.string.places_to_visit_3_description)));
        menuOptions.add(new TourItem(getString(R.string.places_to_visit_4_name), getString(R.string.places_to_visit_4_address), R.drawable.birla_mandir, getString(R.string.places_to_visit_4_description)));
        menuOptions.add(new TourItem(getString(R.string.places_to_visit_5_name), getString(R.string.places_to_visit_5_address), R.drawable.indian_museum, getString(R.string.places_to_visit_5_description)));
        GeneralMenuAdapter generalMenuAdapter = new GeneralMenuAdapter(PlacesToVisitActivity.this, menuOptions);
        ListView menuOptionsGridView = (ListView) findViewById(R.id.places_to_visit_list_view);
        menuOptionsGridView.setAdapter(generalMenuAdapter);
    }

}
