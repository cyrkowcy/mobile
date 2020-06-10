package pl.edu.pk.mobile.tourtool

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
  @get: Rule
  val activityScenario = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun test_isActivityInView() {
      onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()))
  }

  @Test
  fun test_visibility_nav() {

    onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()))

    // onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
  }

  @Test
  fun test_is_login_email_displayed() {

    onView(withId(R.id.login_email)).check(matches(isDisplayed()))
    onView(withId(R.id.login_email)).check(matches(withHint(R.string.login_e_mail)))
  }
  @Test
  fun test_is_login_password_displayed() {

    onView(withId(R.id.login_password)).check(matches(isDisplayed()))
    onView(withId(R.id.login_password)).check(matches(withHint(R.string.password)))
  }
  @Test
  fun test_is_login_button_displayed() {

    onView(withId(R.id.login_login_btn)).check(matches(isDisplayed()))
    onView(withId(R.id.login_login_btn)).check(matches(withText(R.string.log_in)))
  }
  @Test
  fun test_is_signin_button_displayed() {

    onView(withId(R.id.login_signin_btn)).check(matches(isDisplayed()))
    onView(withId(R.id.login_signin_btn)).check(matches(withText(R.string.sign_in)))
  }
  @Test
  fun test_is_progress_bar_hidden() {
    onView(withId(R.id.progressBar)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
  }
}
