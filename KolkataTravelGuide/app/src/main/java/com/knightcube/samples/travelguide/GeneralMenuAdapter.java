package com.knightcube.samples.travelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import at.blogc.android.views.ExpandableTextView;

import static android.content.ContentValues.TAG;
import static com.knightcube.samples.travelguide.R.id.expandableTextView;

public class GeneralMenuAdapter extends ArrayAdapter<TourItem> {

    static class GeneralViewHolder {
        TextView tourItemNameTextView;
        TextView tourItemAddressTextView;
        TextView buttonToggle;
        ExpandableTextView expandableTextView;
        ImageView iconView;
    }

    public GeneralMenuAdapter(@NonNull Context context, ArrayList<TourItem> tourItemArrayList) {
        super(context, 0, tourItemArrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        final GeneralViewHolder generalViewHolder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.general_list_view_item, parent, false);
            generalViewHolder = new GeneralViewHolder();
            generalViewHolder.tourItemNameTextView = (TextView) listItemView.findViewById(R.id.tour_item_name);
            generalViewHolder.tourItemAddressTextView = (TextView) listItemView.findViewById(R.id.tour_item_address);
            generalViewHolder.buttonToggle = (TextView) listItemView.findViewById(R.id.read_more);
            generalViewHolder.iconView = (ImageView) listItemView.findViewById(R.id.tour_item_image);
            generalViewHolder.expandableTextView = (ExpandableTextView) listItemView.findViewById(expandableTextView);
            listItemView.setTag(generalViewHolder);
        } else {
            generalViewHolder = (GeneralViewHolder) listItemView.getTag();
        }

        TourItem tourItem = getItem(position);
        generalViewHolder.tourItemNameTextView.setText(tourItem.getName());
        generalViewHolder.tourItemAddressTextView.setText(tourItem.getAddress());
        generalViewHolder.iconView.setImageResource(tourItem.getImageId());
        generalViewHolder.expandableTextView.setAnimationDuration(1000L);
        generalViewHolder.expandableTextView.setInterpolator(new OvershootInterpolator());
        generalViewHolder.expandableTextView.setExpandInterpolator(new OvershootInterpolator());
        generalViewHolder.expandableTextView.setCollapseInterpolator(new OvershootInterpolator());
        generalViewHolder.expandableTextView.setText(tourItem.getDescription());
        generalViewHolder.buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                generalViewHolder.expandableTextView.toggle();
                generalViewHolder.buttonToggle.setText(generalViewHolder.expandableTextView.isExpanded() ? R.string.collapse : R.string.expand);
            }
        });
        generalViewHolder.buttonToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (generalViewHolder.expandableTextView.isExpanded()) {
                    generalViewHolder.expandableTextView.collapse();
                    generalViewHolder.buttonToggle.setText(R.string.expand);
                } else {
                    generalViewHolder.expandableTextView.expand();
                    generalViewHolder.buttonToggle.setText(R.string.collapse);
                }
            }
        });
        generalViewHolder.expandableTextView.setOnExpandListener(new ExpandableTextView.OnExpandListener() {
            @Override
            public void onExpand(final ExpandableTextView view) {
                Log.d(TAG, "ExpandableTextView expanded");
            }

            @Override
            public void onCollapse(final ExpandableTextView view) {
                Log.d(TAG, "ExpandableTextView collapsed");
            }
        });
        return listItemView;
    }
}
