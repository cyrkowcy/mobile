package pl.edu.pk.mobile.tourtool.view.fragment.signup

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.edu.pk.mobile.tourtool.LiveDataTestUtil.getValue
import pl.edu.pk.mobile.tourtool.MainCoroutineRule
import pl.edu.pk.mobile.tourtool.fragment.signup.SignUpViewModel
import pl.edu.pk.mobile.tourtool.service.data.MockUserRepository

@ExperimentalCoroutinesApi
class SignUpViewModelTest {

  private lateinit var signUpViewModel: SignUpViewModel
  private lateinit var userRepository: MockUserRepository

  @ExperimentalCoroutinesApi
  @get:Rule
  var mainCoroutineRule = MainCoroutineRule()

  @get:Rule
  var instantExecutorRule = InstantTaskExecutorRule()

  @Before
  fun setupViewModel() {
    userRepository = MockUserRepository()
    signUpViewModel = SignUpViewModel(userRepository)
  }

  @Test
  fun shouldAllowToSignUpWithAppropriateCredentials() {
    // given
    signUpViewModel.firstName.postValue("admin")
    signUpViewModel.lastName.postValue("admin")
    signUpViewModel.email.postValue("admin@gmail.com")
    signUpViewModel.password.postValue("admin123")

    // when
    mainCoroutineRule.runBlockingTest {
      signUpViewModel.signupUser()
    }

    // then
    assertThat(getValue(signUpViewModel.signupSuccess).getContentIfNotHandled()).isTrue()
  }
}
