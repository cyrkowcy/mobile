package pl.edu.pk.mobile.tourtool.util

import android.content.Context
import com.auth0.android.jwt.JWT
import javax.inject.Inject
import javax.inject.Singleton
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.Password
import pl.edu.pk.mobile.tourtool.service.repositories.SharedPreferencesRepository

@Singleton
class SharedPreferencesHolder @Inject constructor(
  context: Context
) : SharedPreferencesRepository {
  companion object {
    const val SHARED_PREF_NAME = "TOUR_TOOL_SHARED_PREFERENCES"
    const val USER_TOKEN_PREF_NAME: String = "USER_TOKEN"
    const val EMAIL_PREF_NAME: String = "EMAIL"
    const val PASSWORD_PREF_NAME: String = "PASSWORD"
  }
  private val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

  override fun getToken(): JWT =
    JWT(sharedPref.getString(USER_TOKEN_PREF_NAME, null) ?: error("Token does not exist"))

  override fun setToken(newToken: JWT) {
    sharedPref
      .edit()
      .putString(USER_TOKEN_PREF_NAME, newToken.toString())
      .apply()
  }

  override fun getEmail(): Email =
    Email(sharedPref.getString(EMAIL_PREF_NAME, null) ?: error("Email does not exist"))

  override fun setEmail(newEmail: Email) {
    sharedPref
      .edit()
      .putString(EMAIL_PREF_NAME, newEmail.value)
      .apply()
  }

  override fun getPassword(): Password =
    Password(sharedPref.getString(PASSWORD_PREF_NAME, null) ?: error("Password does not exist"))

  override fun setPassword(newPassword: Password) {
    sharedPref
      .edit()
      .putString(PASSWORD_PREF_NAME, newPassword.toString())
      .apply()
  }
}
