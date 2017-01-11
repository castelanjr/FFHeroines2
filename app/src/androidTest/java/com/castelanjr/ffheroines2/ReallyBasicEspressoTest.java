package com.castelanjr.ffheroines2;

import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import com.castelanjr.ffheroines2.heroine_details.HeroineDetailsActivity;
import com.castelanjr.ffheroines2.heroines.HeroinesActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class ReallyBasicEspressoTest {

    @Rule
    public IntentsTestRule<HeroinesActivity> activityRule =
            new IntentsTestRule<>(HeroinesActivity.class);

    @Test
    public void shouldOpenDetails() {

        IdlingPolicies.setMasterPolicyTimeout(DateUtils.SECOND_IN_MILLIS * 10, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(DateUtils.SECOND_IN_MILLIS * 10, TimeUnit.MILLISECONDS);

        IdlingResource idlingResource = new ElapsedTimeIdlingResource(DateUtils.SECOND_IN_MILLIS * 5);
        registerIdlingResources(idlingResource);

        onView(withId(R.id.recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

        intended(allOf(
                hasComponent(hasShortClassName(".heroine_details.HeroineDetailsActivity")),
                toPackage(BuildConfig.APPLICATION_ID),
                hasExtraWithKey(HeroineDetailsActivity.EXTRA_HEROINE)));

        unregisterIdlingResources(idlingResource);
    }
}
