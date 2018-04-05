package com.knightcube.samples.newsreaderapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsStories>> {

    private NewsStoriesAdapter newsStoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView newsListView = (ListView) findViewById(R.id.news_list_view);
        newsStoriesAdapter = new NewsStoriesAdapter(MainActivity.this);
        newsListView.setAdapter(newsStoriesAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NewsStories newsStories1 = newsStoriesAdapter.getItem(i);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(newsStories1.getNewsUrl()));
                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(1,null,MainActivity.this);
    }

    @Override
    public Loader<List<NewsStories>> onCreateLoader(int i, Bundle bundle) {
        return new NewsStoriesLoader(MainActivity.this);
    }
    @Override
    public void onLoadFinished(Loader<List<NewsStories>> loader, List<NewsStories> newsStories) {
        if (newsStories != null) {
            newsStoriesAdapter.setNotifyOnChange(false);
            newsStoriesAdapter.clear();
            newsStoriesAdapter.setNotifyOnChange(true);
            newsStoriesAdapter.addAll(newsStories);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<NewsStories>> loader) {
    }
}
