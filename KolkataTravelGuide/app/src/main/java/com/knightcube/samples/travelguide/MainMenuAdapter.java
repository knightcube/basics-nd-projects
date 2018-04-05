package com.knightcube.samples.travelguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainMenuAdapter extends ArrayAdapter {
    private ArrayList<String> mMenuOptions;

    static class ViewHolder {
        TextView optionTextView;
        ImageView iconView;
    }

    private int[] mMenuIcons = {
            R.drawable.icons_fast_fact,
            R.drawable.icons_hotels,
            R.drawable.icons_restaurants,
            R.drawable.icons_places_to_visit,
            R.drawable.icons_shopping,
    };

    public MainMenuAdapter(Context context, ArrayList<String> menuOptions, int res) {
        super(context, 0, menuOptions);
        mMenuOptions = menuOptions;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.main_list_view_item, parent, false);
            holder = new ViewHolder();
            holder.optionTextView = (TextView) listItemView.findViewById(R.id.menu_item);
            holder.iconView = (ImageView) listItemView.findViewById(R.id.menu_icon);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }
        holder.optionTextView.setText(mMenuOptions.get(position));
        holder.iconView.setImageResource(mMenuIcons[position]);
        return listItemView;

    }
}
