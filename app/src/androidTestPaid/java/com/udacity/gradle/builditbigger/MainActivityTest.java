package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.idlingResource.EspressoTestingIdlingResource;
import com.udacity.gradle.jokerjavalibrary.Joker;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String EXTRA_JOKE = "jokeExtra";
    private IdlingResource mIdlingResource;

    @Rule
    public IntentsTestRule<MainActivity> mIntentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        mIdlingResource = EspressoTestingIdlingResource.getIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Before
    public void stubAllExternalIntents() {
        intending(not(isInternal()))
                .respondWith(new ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void clickButton_CreatesIntentWithJoke() {
        // Checks that an intent is created and contains an Extra with key EXTRA_JOKE and has
        // a value that is not an empty string.
        String[] funnyJokes = Joker.getFunnyJokes();

        onView(withId(R.id.btn_tell_joke)).perform(click());
        intended(hasExtras(hasEntry(equalTo(EXTRA_JOKE), isIn(funnyJokes))));
    }

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }
}
