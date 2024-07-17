package com.example.amdocsapp;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyMainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void loginTest(){
        //enter 2134567 in etpassword
        onView(withId(R.id.etPassword)).perform(typeText("1234567"), closeSoftKeyboard());
        //click the login button
        onView(withId(R.id.btnLogin)).perform(click());
        //check if the tvtest has 2134567
        onView(withId(R.id.tvtest))
                .check(matches(withText("1234567")));

    }
}
