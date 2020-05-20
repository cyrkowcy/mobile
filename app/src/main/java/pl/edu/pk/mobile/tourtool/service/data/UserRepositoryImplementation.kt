package pl.edu.pk.mobile.tourtool.service.data

import com.auth0.android.jwt.JWT
import javax.inject.Inject
import javax.inject.Singleton
import pl.edu.pk.mobile.tourtool.retrofit.Webservice
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.repositories.UserRepository

@Singleton
class UserRepositoryImplementation @Inject constructor() : UserRepository {
  @Inject
  lateinit var webservice: Webservice
  override suspend fun validateCredentials(email: String, password: String): JWT {
    TODO("Not yet implemented")
//    lateinit var data: JWT
//
//    webservice.login(email, password).enqueue(object : Callback<JWT> {
//      override fun onResponse(call: Call<JWT>, response: Response<JWT>) {
//        data = response.body() ?: JWT("")
//      }
//      override fun onFailure(call: Call<JWT>, t: Throwable) {
//        Log.e("USER_REPOSITORY", t.message ?: "Undefined error")
//      }
//    })
//    return data
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
