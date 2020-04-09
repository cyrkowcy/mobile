package pl.edu.pk.mobile.tourtool.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
    return viewDataBinding.root
  }

  private fun subscribeViewModel() {
    viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
      it.getContentIfNotHandled()?.let { message ->
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
      }
    })
  }
}
