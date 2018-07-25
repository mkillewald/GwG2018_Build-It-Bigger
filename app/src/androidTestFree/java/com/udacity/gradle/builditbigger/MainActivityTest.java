package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.udacity.gradle.builditbigger.idlingResource.EspressoTestingIdlingResource;
import com.udacity.gradle.jokerjavalibrary.Joker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;
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

        // Generated by Espresso Test Recorder
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.btn_tell_joke)).perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Interstitial close button"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.gms.ads.internal.overlay.zzh")),
                                        1),
                                0),
                        isDisplayed()));
        imageButton.perform(click());
        // End Espresso Test Recorder Generated block

        intended(hasExtras(hasEntry(equalTo(EXTRA_JOKE), isIn(funnyJokes))));
    }

    // Generated by Espresso Test Recorder
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    // End Espresso Test Recorder Generated block

    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }
}