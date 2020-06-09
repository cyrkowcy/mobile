package pl.edu.pk.mobile.tourtool.fragment.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import pl.edu.pk.mobile.tourtool.R
import pl.edu.pk.mobile.tourtool.databinding.LoginFragmentBinding
import pl.edu.pk.mobile.tourtool.util.SharedPreferencesHolder

class LoginFragment : DaggerFragment() {

  private lateinit var viewDataBinding: LoginFragmentBinding

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var sharedPreferencesHolder: SharedPreferencesHolder

  private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    AndroidSupportInjection.inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    subscribeViewModel()
    val root = inflater.inflate(R.layout.login_fragment, container, false)
    viewDataBinding = LoginFragmentBinding.bind(root).apply {
      this.viewmodel = viewModel
    }
    return viewDataBinding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

    setupSignUpBtn()
    setupLoginBtn()
  }

  private fun subscribeViewModel() {

    if (isTokenValid()) {
      navigateToLoggedIn()
    }

    viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
      it.getContentIfNotHandled()?.let { message ->
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
      }
    })
    viewModel.loginSuccess.observe(viewLifecycleOwner, Observer {
      it.getContentIfNotHandled()?.let {
        if (it) {

          navigateToLoggedIn()
        }
      }
    })
  }

  private fun setupSignUpBtn() {
    activity?.findViewById<Button>(R.id.login_signin_btn)?.let {
      it.setOnClickListener {
        navigateToSignUp()
      }
    }
  }

  private fun setupLoginBtn() {
    activity?.findViewById<Button>(R.id.login_login_btn)?.let {
      it.setOnClickListener {
        hideKeyboard()
        viewModel.verifyUser()
      }
    }
  }

  private fun navigateToSignUp() {
    val action =
      LoginFragmentDirections.actionToSignUpFragment()
    findNavController().navigate(action)
  }

  private fun navigateToLoggedIn() {
    val action =
      LoginFragmentDirections.actionToLoggedInFragment()
    findNavController().navigate(action)
  }

  private fun isTokenValid(): Boolean {
    try {
      val token = sharedPreferencesHolder.getToken()
      if (!token.isExpired(0)) {
        Log.d("Login Fragment", "Token is valid, auto logging in.")
        return true
      }
    } catch (e: IllegalStateException) {
      Log.d("Login Fragment", "Token does not exist, processing to LoginView")
      return false
    }
    return false
  }
}

fun DaggerFragment.hideKeyboard() {
  val focus = requireActivity().currentFocus
  if (focus != null) {
    val input = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    input.hideSoftInputFromWindow(focus.windowToken, 0)
  }
}
