package pl.edu.pk.mobile.tourtool.view.fragment.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.edu.pk.mobile.tourtool.LiveDataTestUtil.getValue
import pl.edu.pk.mobile.tourtool.MainCoroutineRule
import pl.edu.pk.mobile.tourtool.fragment.login.LoginViewModel
import pl.edu.pk.mobile.tourtool.service.data.MockUserRepository

@ExperimentalCoroutinesApi
class LoginViewModelTest {

  private lateinit var loginViewModel: LoginViewModel

  private lateinit var userRepository: MockUserRepository

  // Set the main coroutines dispatcher for unit testing.
  @ExperimentalCoroutinesApi
  @get:Rule
  var mainCoroutineRule = MainCoroutineRule()

  // Executes each task synchronously using Architecture Components.
  @get:Rule
  var instantExecutorRule = InstantTaskExecutorRule()

  @Before
  fun setupViewModel() {
    userRepository = MockUserRepository()
    loginViewModel = LoginViewModel(userRepository)
  }

  @Test
  fun shouldProduceEventMissingEmail() {
    // when
    mainCoroutineRule.runBlockingTest {
      loginViewModel.verifyUser()
    }
    assertThat(getValue(loginViewModel.toastMessage).getContentIfNotHandled()).isEqualTo("Enter email")
  }

  @Test
  fun shouldProduceEventMissingPassword() {
    // given
    loginViewModel.email.postValue("test@test.test")

    // when
    mainCoroutineRule.runBlockingTest {
      loginViewModel.verifyUser()
    }

    // then
    assertThat(getValue(loginViewModel.toastMessage).getContentIfNotHandled()).isEqualTo("Enter password")
  }

  @Test
  fun shouldProduceEventWrongCredentials() {
    // given
    loginViewModel.email.postValue("wrong@test.test")
    loginViewModel.password.postValue("wrongPass")

    // when
    mainCoroutineRule.runBlockingTest {
      loginViewModel.verifyUser()
    }

    // then
    assertThat(getValue(loginViewModel.toastMessage).getContentIfNotHandled()).isEqualTo("Wrong credentials")
  }

  @Test
  fun shouldAllowToLoginWithCorrectCredentials() {
    // given
    loginViewModel.email.postValue("test@test.test")
    loginViewModel.password.postValue("secret123")

    // when
    mainCoroutineRule.runBlockingTest {
      loginViewModel.verifyUser()
    }

    // then
    assertThat(getValue(loginViewModel.loginSuccess).getContentIfNotHandled()).isTrue()
  }
}
