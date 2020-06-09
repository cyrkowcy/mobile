package pl.edu.pk.mobile.tourtool.fragment.signup
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
import pl.edu.pk.mobile.tourtool.databinding.SignUpFragmentBinding

class SignUpFragment : DaggerFragment() {

  private lateinit var viewDataBinding: SignUpFragmentBinding

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel by viewModels<SignUpViewModel> { viewModelFactory }

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
    val root = inflater.inflate(R.layout.sign_up_fragment, container, false)
    viewDataBinding = SignUpFragmentBinding.bind(root).apply {
      this.viewmodel = viewModel
    }
    return viewDataBinding.root
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

    setupLoginBtn()
  }

  private fun subscribeViewModel() {
    viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
      it.getContentIfNotHandled()?.let { message ->
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
      }
    })
    viewModel.signupSuccess.observe(viewLifecycleOwner, Observer {
      it.getContentIfNotHandled()?.let {
        if (it) {
          navigateToLoggedIn()
        }
      }
    })
  }

  private fun setupLoginBtn() {
    activity?.findViewById<Button>(R.id.signup_login_btn)?.let {
      it.setOnClickListener {
        navigateToLogin()
      }
    }
  }

  private fun navigateToLogin() {
    val action =
      SignUpFragmentDirections.actionToLoginFragment()
    findNavController().navigate(action)
  }

  private fun navigateToLoggedIn() {
    val action =
      SignUpFragmentDirections.actionToLoginFragment()
    findNavController().navigate(action)
  }
}
