package com.journaldev.androidexpressobasics;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    public static final String USERNAME_TYPED = "Anupam";

    public static final String LOGIN_TEXT = "Hello Anupam";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.journaldev.androidexpressobasics", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void loginClickedSuccess() {
        onView(withId(R.id.inUsername))
                .perform(typeText(USERNAME_TYPED));
        onView(withId(R.id.inNumber))
                .perform(typeText("12345"));
        onView(withId(R.id.inConfirmNumber))
                .perform(typeText("12345"));

        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.txtLoginResult)).check(matches(withText(LOGIN_TEXT)));
    }


    @Test
    public void shouldShowToastError() {
        onView(withId(R.id.inUsername))
                .perform(typeText(USERNAME_TYPED));
        onView(withId(R.id.inNumber))
                .perform(typeText("123456"));
        onView(withId(R.id.inConfirmNumber))
                .perform(typeText("12345"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText(R.string.toast_error)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowToastUsernameEmpty() {
        onView(withId(R.id.inNumber))
                .perform(typeText("12345"));
        onView(withId(R.id.inConfirmNumber))
                .perform(typeText("12345"));

        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText(R.string.username_empty)).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}
