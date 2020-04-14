package pl.edu.pk.mobile.tourtool.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.launch
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.Password
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException
import pl.edu.pk.mobile.tourtool.util.Event

class LoginViewModel @Inject constructor(
  val userRepository: UserRepository
) : ViewModel() {

  // Two-way databinding, exposing MutableLiveData
  val email = MutableLiveData<String>()
  private val _email = String()

  // Two-way databinding, exposing MutableLiveData
  val password = MutableLiveData<String>()
  private val _password = String()

  // One-way databinding, exposing only immutable LiveData
  private val _dataLoading = MutableLiveData<Boolean>(false)
  val dataLoading: LiveData<Boolean> = _dataLoading

  // One-way databinding, exposing only immutable LiveData
  private val _loginSuccess = MutableLiveData<Event<Boolean>>()
  val loginSuccess: LiveData<Event<Boolean>> = _loginSuccess

  private val _toastMessage = MutableLiveData<Event<String>>()
  val toastMessage: LiveData<Event<String>> = _toastMessage

  fun verifyUser() {
    if (this.email.value.isNullOrBlank()) {
      _toastMessage.value = Event("Enter email")
      return
    }
    if (this.password.value.isNullOrBlank()) {
      _toastMessage.value = Event("Enter password")
      return
    }
    viewModelScope.launch {
      try {
        _dataLoading.postValue(true)
        userRepository.validateCredentials(
          Email(email.value.toString()),
          Password(password.value.toString())
        )
        _loginSuccess.value = Event(true)
        _dataLoading.postValue(false)
      } catch (e: WrongCredentialsException) {
        _dataLoading.postValue(false)
        _toastMessage.value = Event(e.message.toString())
      }
    }
  }
}
