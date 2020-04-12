package pl.edu.pk.mobile.tourtool.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class LoginFragment : DaggerFragment() {

  private lateinit var viewDataBinding: LoginFragmentBinding

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

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
  }

  private fun subscribeViewModel() {
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
}
