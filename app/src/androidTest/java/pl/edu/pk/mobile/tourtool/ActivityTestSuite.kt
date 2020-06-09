package pl.edu.pk.mobile.tourtool

import org.junit.runner.RunWith
import org.junit.runners.Suite
import pl.edu.pk.mobile.tourtool.fragment.loggedin.LoggedInFragmentTest
import pl.edu.pk.mobile.tourtool.fragment.signup.SignUpFragmentTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
  MainActivityTest::class,
  LoggedInFragmentTest::class,
  SignUpFragmentTest::class
)
class ActivityTestSuite
