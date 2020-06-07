package pl.edu.pk.mobile.tourtool.fragment.loggedin

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.edu.pk.mobile.tourtool.MainActivity
import pl.edu.pk.mobile.tourtool.R

@RunWith(AndroidJUnit4ClassRunner::class)
class LoggedInFragmentTest{

  @Test
  fun test_is_login_message_displayed() {
    val activityScenario=ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.login_email)).perform(typeText("test@test.test"))
    Espresso.pressBack()
    onView(withId(R.id.login_password)).perform(typeText("secret123"))
    Espresso.pressBack()
    onView(withId(R.id.login_login_btn)).perform(click())
    onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    Thread.sleep(5000);
    onView(withId(R.id.textView)).check(matches(isDisplayed()))
    onView(withId(R.id.textView)).check(matches(withText("Hello World!!!")))

  }

  @Test
  fun test_is_back_button_working() {
    val activityScenario=ActivityScenario.launch(MainActivity::class.java)
    onView(withId(R.id.login_email)).perform(typeText("test@test.test"))
    Espresso.pressBack()
    onView(withId(R.id.login_password)).perform(typeText("secret123"))
    Espresso.pressBack()
    onView(withId(R.id.login_login_btn)).perform(click())
    onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    Thread.sleep(5000);
    onView(withId(R.id.textView)).check(matches(isDisplayed()))
    onView(withId(R.id.textView)).check(matches(withText("Hello World!!!")))

    Espresso.pressBack()

    onView(withId(R.id.login_email)).check(matches(isDisplayed()))
    onView(withId(R.id.login_password)).check(matches(isDisplayed()))
    onView(withId(R.id.login_login_btn)).check(matches(isDisplayed()))
  }
}
