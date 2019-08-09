package com.company.app.tbsnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /** define global variables used in this class. **/

    // Buttons to display News
    Button tNews, bNews, sNews;

    // bundle is bundle information about this activity
    // execute of activity start from onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to buttons into activity_main layout
        tNews = (Button)findViewById(R.id.tNews);
        bNews = (Button)findViewById(R.id.bNews);
        sNews = (Button)findViewById(R.id.sNews);


        tNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass Intent with value 1 from tech news button
                int value  = 1;
                Intent i = new Intent(MainActivity.this, NewsActivity.class);
                i.putExtra("epuzzle", value);
                startActivity(i);
            }
        });

        bNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass Intent with value 2 from business news button
                int value  = 2;
                Intent i = new Intent(MainActivity.this, NewsActivity.class);
                i.putExtra("epuzzle", value);
                startActivity(i);
            }
        });

        sNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass Intent with value 3 from science news button
                int value  = 3;
                Intent i = new Intent(MainActivity.this, NewsActivity.class);
                i.putExtra("epuzzle", value);
                startActivity(i);

            }
        });



        // reference to technology Button in layout
         // technology = (Button) findViewById(R.id.technology);

        // reference to science Button in layout
        // science = (Button) findViewById(R.id.science);

        // reference to business Button in layout
        // business = (Button) findViewById(R.id.business);

        // reference to ProgressBar loading_indicator in layout
        // loadingIndicator = (ProgressBar) findViewById(R.id.loading_indicator)

    }

}

