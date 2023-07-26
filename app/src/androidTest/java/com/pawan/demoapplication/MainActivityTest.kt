package com.pawan.demoapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    //checking layout is Visible or not
    @Test
    fun checkActivityVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.layout_mainActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    //checking if text "Main Activity" is visible
    @Test
    fun checkTextVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.txtMainActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // checking button is visible
        Espresso.onView(ViewMatchers.withId(R.id.btnGoSecondActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    // checking text on view
    @Test
    fun testTextIsMainActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.txtMainActivity))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.main_activity)))
    }

    //click on button
    @Test
    fun navigateToSecondActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.btnGoSecondActivity))
            .perform(ViewActions.click())

        //check visible second activity
        Espresso.onView(ViewMatchers.withId(R.id.second_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    //testing back press button
    @Test
    fun backPressToMainActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.btnGoSecondActivity))
            .perform(ViewActions.click())

        //check visible second activity
        Espresso.onView(ViewMatchers.withId(R.id.second_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //check backpress
        Espresso.pressBack()
        // now check mainactivity is visible
        Espresso.onView(ViewMatchers.withId(R.id.layout_mainActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
