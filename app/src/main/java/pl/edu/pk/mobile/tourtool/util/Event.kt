package pl.edu.pk.mobile.tourtool.util

open class Event<out T>(private val content: T) {
  private var hasBeenHandled = false

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
}
