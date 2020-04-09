package pl.edu.pk.mobile.tourtool.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import pl.edu.pk.mobile.tourtool.model.Email
import pl.edu.pk.mobile.tourtool.model.Password
import pl.edu.pk.mobile.tourtool.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.repositories.WrongCredentialsException
import pl.edu.pk.mobile.tourtool.utils.Event
import kotlin.math.E

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
        userRepository.validateCredentials(Email(email.value.toString()), Password(password.value.toString()))
        _dataLoading.postValue(false)
      } catch (e: WrongCredentialsException) {
        _dataLoading.postValue(false)
        _toastMessage.value = Event("Wrong credentials")
      }
    }

  }
}
