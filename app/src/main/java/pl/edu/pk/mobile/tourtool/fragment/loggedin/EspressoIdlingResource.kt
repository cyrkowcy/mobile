package pl.edu.pk.mobile.tourtool.fragment.loggedin

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
  private const val RESOURCE = "GLOBAL"
  @JvmField val countingIdlingResource = CountingIdlingResource(RESOURCE)
  fun increment() {
    countingIdlingResource.increment()
  }
  fun decrement() {
    if (!countingIdlingResource.isIdleNow) {
      countingIdlingResource.decrement()
    }
  }
}
