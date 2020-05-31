package pl.edu.pk.mobile.tourtool.service.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import pl.edu.pk.mobile.tourtool.util.SharedPreferencesHolder

class TokenInterceptor constructor(
  private val sharedPreferencesHolder: SharedPreferencesHolder
) : Interceptor {

  init {
    Log.d("Token interceptor", "Interceptor initialised")
  }

  override fun intercept(chain: Interceptor.Chain): Response {

    val original = chain.request()

    return if (original.url().encodedPath().contains("/login") && original.method().equals("post") ||
      (original.url().encodedPath().contains("/user") && original.method().equals("post"))
    ) {
      chain.proceed(original)
    } else {
      Log.d(
        "Token interceptor",
        "Adding token ${sharedPreferencesHolder.getToken()} to request to ${original.url().encodedPath()}"
      )
      val originalUrl = original.url()
      val request = original.newBuilder()
        .addHeader("Authorization", sharedPreferencesHolder.getToken().toString())
        .url(originalUrl)
        .build()
      chain.proceed(request)
    }
  }
}
