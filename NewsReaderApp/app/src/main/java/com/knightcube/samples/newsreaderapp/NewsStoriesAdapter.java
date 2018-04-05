package com.knightcube.samples.newsreaderapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsStoriesAdapter extends ArrayAdapter<NewsStories> {
    public NewsStoriesAdapter(@NonNull Context context) {
        super(context, 0);
    }

    static class NewsViewHolder {
        TextView newsTitleText;
        TextView newsDateText;
        TextView newsSectionText;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        NewsViewHolder newsViewHolder = new NewsViewHolder();
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);

            newsViewHolder.newsTitleText = (TextView) listItemView.findViewById(R.id.news_title_text);
            newsViewHolder.newsDateText = (TextView) listItemView.findViewById(R.id.news_date_text);
            newsViewHolder.newsSectionText = (TextView) listItemView.findViewById(R.id.news_section_text);
            listItemView.setTag(newsViewHolder);
        } else {
            newsViewHolder = (NewsViewHolder) listItemView.getTag();
        }
        NewsStories currentNewsStory = getItem(position);
        newsViewHolder.newsTitleText.setText(currentNewsStory.getNewsTitle());
        newsViewHolder.newsDateText.setText(currentNewsStory.getNewsDate());
        newsViewHolder.newsSectionText.setText(currentNewsStory.getNewsSectionName());
        return listItemView;
    }
}
