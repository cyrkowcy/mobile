package pl.edu.pk.mobile.tourtool.util

import android.content.Context
import android.view.inputmethod.InputMethodManager
import dagger.android.support.DaggerFragment

fun DaggerFragment.hideKeyboard() {
  val focus = requireActivity().currentFocus
  if (focus != null) {
    val input = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    input.hideSoftInputFromWindow(focus.windowToken, 0)
  }
}
