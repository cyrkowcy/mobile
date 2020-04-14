package pl.edu.pk.mobile.tourtool.service.data

import kotlinx.coroutines.delay
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.JWT
import pl.edu.pk.mobile.tourtool.service.model.Password
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException

object MockUserRepository : UserRepository {
  override suspend fun validateCredentials(email: Email, password: Password): JWT {
    delay(5000)
    return if (email.value == "test@test.test" && password.value == "secret123")
      JWT("token123")
    else
      throw WrongCredentialsException("Wrong credentials")
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
