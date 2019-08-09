/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.app.tbsnews;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each News
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    // Resource ID for the background color for this list
    private int mColorResourceId;

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param newsList is the list of NEWS, which is the data source of the adapter
     * @param colorResourceId is the resource id of the color
     */
    public NewsAdapter(Context context, List<News> newsList, int colorResourceId)
    {
        super(context, 0, newsList);
        mColorResourceId = colorResourceId;
    }

    // getView method return a view that displays data at specific position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // getItem(position) to return data item at a specific position in the list
        News currentNews = getItem(position);

        // Find the TextView with view ID title
        TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(currentNews.getTitle());

        // Find the TextView with view ID webPublicationDate
        TextView webPublicationDate = (TextView) listItemView.findViewById(R.id.webPublicationDate);
        webPublicationDate.setText(currentNews.getWebPublicationDate());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        // textContainer.setBackgroundColor(color);
        textContainer.setBackgroundColor(color);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
