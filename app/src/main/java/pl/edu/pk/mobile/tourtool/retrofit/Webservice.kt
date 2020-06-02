package pl.edu.pk.mobile.tourtool.retrofit

import com.auth0.android.jwt.JWT
import pl.edu.pk.mobile.tourtool.service.dto.CredentialsDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Webservice {
  @POST("login")
  fun login(
    @Body credentialsDTO: CredentialsDTO
  ): Call<JWT>
}
