package pl.edu.pk.mobile.tourtool.service.data

import com.auth0.android.jwt.JWT
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton
import pl.edu.pk.mobile.tourtool.retrofit.Webservice
import pl.edu.pk.mobile.tourtool.service.dto.CredentialsDTO
import pl.edu.pk.mobile.tourtool.service.dto.LoginErrorDTO
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository
import pl.edu.pk.mobile.tourtool.service.repositories.WrongCredentialsException
import retrofit2.awaitResponse

@Singleton
class UserRepositoryImplementation @Inject constructor() : UserRepository {
  @Inject
  lateinit var webservice: Webservice
  override suspend fun validateCredentials(email: String, password: String): JWT {
    lateinit var data: JWT

    val response = webservice.login(CredentialsDTO(email, password)).awaitResponse()

    if (response.isSuccessful) {
      data = JWT(response.body().toString())
    } else {
      val gson = Gson()
      val error = gson.fromJson(response.errorBody()?.charStream(), LoginErrorDTO::class.java)
      throw WrongCredentialsException(error.message)
    }

    return data
  }

  override suspend fun getUser(): User {
    TODO("Not yet implemented")
  }

  override suspend fun createUser(user: User) {
    val response = webservice
  }

  override suspend fun updateUser(user: User) {
    TODO("Not yet implemented")
  }
}
