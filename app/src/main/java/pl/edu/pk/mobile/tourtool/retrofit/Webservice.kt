package pl.edu.pk.mobile.tourtool.retrofit

import com.auth0.android.jwt.JWT
import pl.edu.pk.mobile.tourtool.service.dto.CredentialsDTO
import pl.edu.pk.mobile.tourtool.service.dto.UserDTO
import pl.edu.pk.mobile.tourtool.service.model.User
import pl.edu.pk.mobile.tourtool.service.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface Webservice {
  @POST("login")
  fun login(
    @Body credentialsDTO: CredentialsDTO
  ): Call<JWT>

  @GET("user")
  fun getUser(): Call<User>

  @POST("user")
  fun postUser(@Body user: UserDTO): Call<UserResponse>

  @PATCH("user/{email}")
  fun patchUser(@Body user: UserDTO)
}
