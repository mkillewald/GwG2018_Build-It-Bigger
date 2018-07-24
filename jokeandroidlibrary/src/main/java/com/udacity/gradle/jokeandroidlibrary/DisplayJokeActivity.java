package com.udacity.gradle.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "jokeExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);

        TextView jokeTextView = findViewById(R.id.tv_joke);
        jokeTextView.setText(joke);
    }
}
