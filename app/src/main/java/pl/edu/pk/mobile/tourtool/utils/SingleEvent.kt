package pl.edu.pk.mobile.tourtool.utils

open class Event<out T>(private val content: T) {
  var hasBeenHandled = false
    private set

  /**
   * Returns the content and prevents its being used again.
   */
  fun getContentIfNotHandled(): T? =
    if (hasBeenHandled) {
      null
    } else {
      hasBeenHandled = true
      content
    }


  /**
   * Returns the content, even if it's already been handled.
   */
  fun peakContent(): T = content
}
