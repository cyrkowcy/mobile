package pl.edu.pk.mobile.tourtool.data

import android.util.Log
import kotlinx.coroutines.delay
import pl.edu.pk.mobile.tourtool.model.Email
import pl.edu.pk.mobile.tourtool.model.JWT
import pl.edu.pk.mobile.tourtool.model.Password
import pl.edu.pk.mobile.tourtool.model.User
import pl.edu.pk.mobile.tourtool.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.repositories.WrongCredentialsException

object MockUserRepository : UserRepository {
  override suspend fun validateCredentials(email: Email, password: Password): JWT {
    Log.d("MockUserRepository", email.value)
    delay(5000)
    return if (email.value == "janusz@tracz.test" && password.value == "secret123")
      JWT("token123")
    else
      throw WrongCredentialsException("dupa, złe dane")
  }

  override suspend fun getUser(token: JWT): User {
    TODO("Not yet implemented")
  }

  override suspend fun createUser(user: User) {
    TODO("Not yet implemented")
  }

  override suspend fun updateUser(user: User, token: JWT) {
    TODO("Not yet implemented")
  }
}
