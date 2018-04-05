package com.knightcube.samples.booklistingapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import at.blogc.android.views.ExpandableTextView;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(@NonNull Context context, @NonNull List<Book> books) {
        super(context,0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }
        Book currentBook = getItem(position);

        TextView bookTitleText = (TextView)listItemView.findViewById(R.id.book_title);
        TextView bookAuthorText = (TextView)listItemView.findViewById(R.id.book_author);
        final ExpandableTextView bookDescriptionText = (ExpandableTextView) listItemView.findViewById(R.id.book_description);;
        final TextView buttonToggle = (TextView) listItemView.findViewById(R.id.read_more);
        bookTitleText.setText(currentBook.getTitle());
        bookAuthorText.setText(currentBook.getAuthors());
        bookDescriptionText.setAnimationDuration(1000L);
        bookDescriptionText.setInterpolator(new OvershootInterpolator());
        bookDescriptionText.setExpandInterpolator(new OvershootInterpolator());
        bookDescriptionText.setCollapseInterpolator(new OvershootInterpolator());
        bookDescriptionText.setText(currentBook.getDescription());
        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                bookDescriptionText.toggle();
                buttonToggle.setText(bookDescriptionText.isExpanded() ? R.string.collapse_text :R.string.expand_text);
            }
        });
        buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (bookDescriptionText.isExpanded()) {
                    bookDescriptionText.collapse();
                    buttonToggle.setText(R.string.expand_text);
                } else {
                    bookDescriptionText.expand();
                    buttonToggle.setText(R.string.collapse_text);
                }
            }
        });
        return listItemView;
    }
}
