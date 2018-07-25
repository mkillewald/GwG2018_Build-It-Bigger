package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.jokerandroidlibrary.DisplayJokeActivity;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "jokeExtra";

    // replace with actual App ID and Ad Unit ID for production release
    private static final String APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";

    private String mJoke;
    private ProgressBar mLoadingIndicator;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);

        MobileAds.initialize(this, APP_ID);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(AD_UNIT_ID);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                displayJoke();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        mLoadingIndicator.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask(new EndpointsAsyncTask.AsyncResponse() {
            @Override
            public void returnJoke(String joke) {
                mJoke = joke;

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

                mLoadingIndicator.setVisibility(View.INVISIBLE);
            }
        }).execute(this);
    }

    private void displayJoke() {
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(EXTRA_JOKE, mJoke);

        startActivity(intent);
    }


}
