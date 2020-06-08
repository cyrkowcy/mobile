package pl.edu.pk.mobile.tourtool.service.repositories

import com.auth0.android.jwt.JWT
import java.lang.Exception
import pl.edu.pk.mobile.tourtool.service.model.User

interface UserRepository {
  suspend fun validateCredentials(email: String, password: String): JWT
  suspend fun getUser(): User
  suspend fun createUser(user: User)
  suspend fun updateUser(user: User)
}

class WrongCredentialsException(message: String) : Exception(message)

class ServerResponseException(message: String) : Exception(message)
