package pl.edu.pk.mobile.tourtool.service.repositories

import com.auth0.android.jwt.JWT
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.Password

interface SharedPreferencesRepository {
  fun getToken(): JWT
  fun setToken(newToken: JWT)
  fun getEmail(): Email
  fun setEmail(newEmail: Email)
  fun getPassword(): Password
  fun setPassword(newPassword: Password)
}
