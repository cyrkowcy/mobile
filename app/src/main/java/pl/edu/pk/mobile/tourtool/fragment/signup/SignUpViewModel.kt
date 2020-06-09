package pl.edu.pk.mobile.tourtool.fragment.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.launch
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.Name
import pl.edu.pk.mobile.tourtool.service.model.Password
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException
import pl.edu.pk.mobile.tourtool.util.Event

class SignUpViewModel @Inject constructor(
  private val userRepository: UserRepository
) : ViewModel() {
  // Two-way databinding, exposing MutableLiveData
  val firstName = MutableLiveData<String>()
  val fName = firstName.value

  val lastName = MutableLiveData<String>()
  val lName = lastName.value

  val email = MutableLiveData<String>()
  val em = email.value

  // Two-way databinding, exposing MutableLiveData
  val password = MutableLiveData<String>()
  val pword = password.value

  private val _toastMessage = MutableLiveData<Event<String>>()
  val toastMessage: LiveData<Event<String>> = _toastMessage

  // One-way databinding, exposing only immutable LiveData
  private val _dataLoading = MutableLiveData(false)

  private val _signupSuccess = MutableLiveData<Event<Boolean>>()
  val signupSuccess: LiveData<Event<Boolean>> = _signupSuccess

  fun signupUser() {
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
        userRepository.createUser(
          User(Name(fName.toString()), Name(lName.toString()),
            Email(em.toString()), Password(pword.toString()))
        )
        _signupSuccess.value = Event(true)
        _dataLoading.postValue(false)
      } catch (e: WrongCredentialsException) {
        _dataLoading.postValue(false)
        _toastMessage.value = Event(e.message.toString())
      }
    }
  }
}
