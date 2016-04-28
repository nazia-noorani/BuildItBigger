package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by nazianoorani on 27/04/16.
 */
public class TestJoke extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;

    public TestJoke(Class<MainActivity> activityClass) {
        super(activityClass);
    }
    @Before
    public void setUp() throws Exception{
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
    }
    @Test
    public void testJokeFetchTask(){

        activity.setTestingAsync(true);
        onView(withId(R.id.instructions_text_view)).perform(click());
        assertNotNull(activity.mResult);

    }
}
