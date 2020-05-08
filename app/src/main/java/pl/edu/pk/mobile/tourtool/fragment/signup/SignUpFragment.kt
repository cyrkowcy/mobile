package pl.edu.pk.mobile.tourtool.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import pl.edu.pk.mobile.tourtool.R

class SignUpFragment : Fragment() {

  companion object {
    fun newInstance() = SignUpFragment()
  }

  private lateinit var viewModel: SignUpViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.sign_up_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
  }
  private fun setupLoginBtn(){
    activity?.findViewById<Button>(R.id.signup_login_btn)?.let{
      it.setOnClickListener {
        navigateLogin()
      }
    }
  }
  private fun navigateLogin(){
    val action =
      SignUpFragmentDirections.actionToLoginFragment()
    findNavController().navigate(action)
  }
}
