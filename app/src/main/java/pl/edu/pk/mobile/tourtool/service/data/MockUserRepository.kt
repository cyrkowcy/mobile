package pl.edu.pk.mobile.tourtool.service.data

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay
import pl.edu.pk.mobile.tourtool.service.model.JWT
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException

@Singleton
class MockUserRepository @Inject constructor() : UserRepository {
  override suspend fun validateCredentials(email: String, password: String): JWT {
    delay(5000)
    return if (email == "test@test.test" && password == "secret123")
      JWT("token123")
    else
      throw WrongCredentialsException("Wrong credentials")
  }

  override suspend fun getUser(token: JWT): User {
    TODO("Not yet implemented")
  }

  override suspend fun createUser(user: User) {
    val user: List<User> = listOf(User("admin", "admin", "admin@gmail.com", "admin123"))
  }

  override suspend fun updateUser(user: User, token: JWT) {
    TODO("Not yet implemented")
  }
}
