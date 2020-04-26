package pl.edu.pk.mobile.tourtool.fragment.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException
import pl.edu.pk.mobile.tourtool.util.Event
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
  val userRepository: UserRepository
): ViewModel() {
  // TODO: Implement the ViewModel
  // Two-way databinding, exposing MutableLiveData
  val firstName = MutableLiveData<String>()
  private val _firstName = String()

  val lastName = MutableLiveData<String>()
  private val _lastName = String()

  val email = MutableLiveData<String>()
  private val _email = String()

  // Two-way databinding, exposing MutableLiveData
  val password = MutableLiveData<String>()
  private val _password = String()

  private val _toastMessage = MutableLiveData<Event<String>>()
  val toastMessage: LiveData<Event<String>> = _toastMessage

  // One-way databinding, exposing only immutable LiveData
  private val _dataLoading = MutableLiveData<Boolean>(false)
  val dataLoading: LiveData<Boolean> = _dataLoading

  private val _signupSuccess = MutableLiveData<Event<Boolean>>()
  val signupSuccess: LiveData<Event<Boolean>> = _signupSuccess

  fun signupUser(){
      if(this.email.value.isNullOrEmpty() || this.password.value.isNullOrEmpty()){
        _toastMessage.value = Event("Invalid email or password")
        return
      }
      viewModelScope.launch {
        try{
          _dataLoading.postValue(true)
          userRepository.createUser(

          )
          _signupSuccess.value = Event(true)
          _dataLoading.postValue(false)
        } catch (e: WrongCredentialsException){
          _dataLoading.postValue(false)
          _toastMessage.value = Event(e.message.toString())
        }
      }
  }
}
