package com.knightcube.samples.newsreaderapp;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class NewsStoriesLoader extends AsyncTaskLoader<List<NewsStories>> {

    public NewsStoriesLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        Log.i("Method-->", "onStartLoading");
        forceLoad();
    }

    @Override
    public List<NewsStories> loadInBackground() {
        List<NewsStories> listOfNews = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            listOfNews = QueryUtils.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Queryutils", "Error Loader LoadInBackground: ", e);
        }
        return listOfNews;
    }
}
