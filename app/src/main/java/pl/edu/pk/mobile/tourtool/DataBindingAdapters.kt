package pl.edu.pk.mobile.tourtool

import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter

@BindingAdapter("android:animatedVisibility")
fun setAnimatedVisibility(target: View, isVisible: Boolean) {
  TransitionManager.beginDelayedTransition(target.rootView as ViewGroup)
  target.visibility = if (isVisible) View.VISIBLE else View.GONE
}
