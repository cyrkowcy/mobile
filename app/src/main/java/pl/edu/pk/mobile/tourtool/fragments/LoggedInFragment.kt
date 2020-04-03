package pl.edu.pk.mobile.tourtool.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.edu.pk.mobile.tourtool.R

class LoggedInFragment : Fragment() {

  companion object {
    fun newInstance() = LoggedInFragment()
  }

  private lateinit var viewModel: LoggedInViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.logged_in_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(LoggedInViewModel::class.java)
    // TODO: Use the ViewModel
  }

}
