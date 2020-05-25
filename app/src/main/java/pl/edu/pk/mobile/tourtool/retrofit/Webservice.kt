package pl.edu.pk.mobile.tourtool.retrofit

import com.auth0.android.jwt.JWT
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Webservice {
  @POST("/login")
  @FormUrlEncoded
  fun login(
    @Field("email")
    email: String,
    @Field("password")
    password: String
  ): Call<JWT>
}
