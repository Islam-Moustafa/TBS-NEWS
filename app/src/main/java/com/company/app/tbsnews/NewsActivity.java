package com.company.app.tbsnews;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islam on 4/7/2019.
 */

public class NewsActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>> {

    // Define global variables

    // Value taken from intent
    int value;

    // This query variable to pass to onCreateLoader method to can change content of loader
    String query;

    // Specify integer ID for loader, to distinguish between loaders
    private static final int NEWS_LOADER_ID = 1;

    // listView to handle list of news in UI
    ListView newsListView;

    // Adapter to put list of news into ListView
    private NewsAdapter mAdapter;

    // TextView that is displayed when the list is empty
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        // LoaderManager to control in Loader
        final LoaderManager loaderManager = getLoaderManager();

        // reference to list ListView in layout
        newsListView = (ListView) findViewById(R.id.list);

        // reference to empty_view in the layout, to hold empty state when no books in the list
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);


        Intent intent = getIntent();
        value = intent.getExtras().getInt("epuzzle");

        if(value == 1) {
            // First check internet connection

            // reference to CONNECTIVITY_SERVICE by ConnectivityManager to check state network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);

            // NetworkInfo represent current state of network connection
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            // If there is a network connection, fetch data
            if(networkInfo != null && networkInfo.isConnected()){

                // Create a new adapter that takes an empty list of news as input
                mAdapter = new NewsAdapter(this, new ArrayList<News>(), R.color.category_tech);

                // Set the adapter on the ListView to display elements in UI
                newsListView.setAdapter(mAdapter);

                query =  "https://content.guardianapis.com/technology?api-key=test";
                loaderManager.restartLoader(NEWS_LOADER_ID, null, NewsActivity.this);
            }
            else{
                // show emptyView instead of listView elements
                mEmptyStateTextView.setText("No Internet Connection");
                newsListView.setEmptyView(mEmptyStateTextView);
            }
        }
        else if(value == 2) {
            // First check internet connection

            // reference to CONNECTIVITY_SERVICE by ConnectivityManager to check state network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);

            // NetworkInfo represent current state of network connection
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            // If there is a network connection, fetch data
            if(networkInfo != null && networkInfo.isConnected()){
                // Create a new adapter that takes an empty list of news as input
                mAdapter = new NewsAdapter(this, new ArrayList<News>(), R.color.category_busines);

                // Set the adapter on the ListView to display elements in UI
                newsListView.setAdapter(mAdapter);

                query =  "https://content.guardianapis.com/business?api-key=test";
                loaderManager.restartLoader(NEWS_LOADER_ID, null, NewsActivity.this);
            }
            else{
                // show emptyView instead of listView elements
                mEmptyStateTextView.setText("No Internet Connection");
                newsListView.setEmptyView(mEmptyStateTextView);
            }
        }
        else {
            // First check internet connection

            // reference to CONNECTIVITY_SERVICE by ConnectivityManager to check state network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);

            // NetworkInfo represent current state of network connection
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            // If there is a network connection, fetch data
            if(networkInfo != null && networkInfo.isConnected()){
                // Create a new adapter that takes an empty list of news as input
                mAdapter = new NewsAdapter(this, new ArrayList<News>(), R.color.category_science);

                // Set the adapter on the ListView to display elements in UI
                newsListView.setAdapter(mAdapter);

                query = "https://content.guardianapis.com/science?api-key=test";
                loaderManager.restartLoader(NEWS_LOADER_ID, null, NewsActivity.this);
            }
            else{
                // show emptyView instead of listView elements
                mEmptyStateTextView.setText("No Internet Connection");
                newsListView.setEmptyView(mEmptyStateTextView);
            }
        }


        // Click on each element in listView to open this in new activity by intent
        // Parsing URL of each element from JSON file
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current NEW that was clicked on
                News current = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri newsUri = Uri.parse(current.getUrl());

                // Create a new intent to view the NEW URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }


    // onCreateLoader to create and return a new loader
    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(NewsActivity.this, query);
    }

    // onLoadFinished() called when loader is finished loading data to update UI by loader result
    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newsList) {

        // Clear the adapter of previous data
        mAdapter.clear();

        // if there is a valid list of News then add to adapter to update bookListView
        if (newsList != null && !newsList.isEmpty()) {
            mAdapter.addAll(newsList);
        }
    }

    // onLoaderReset method to reset(clear) loader when fetching error data
    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

}
