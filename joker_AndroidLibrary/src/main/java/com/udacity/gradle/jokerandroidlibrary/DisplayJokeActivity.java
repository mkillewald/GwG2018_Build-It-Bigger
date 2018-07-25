package com.udacity.gradle.jokerandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "jokeExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView jokeTextView = findViewById(R.id.tv_joke);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(EXTRA_JOKE)) {
            jokeTextView.setText(bundle.getString(EXTRA_JOKE));
        }
    }
}
