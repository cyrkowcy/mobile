package pl.edu.pk.mobile.tourtool.service.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CredentialsDTO(
  @SerializedName("email")
  @Expose
  val email: String,
  @SerializedName("password")
  @Expose
  val password: String

) {
  override fun toString(): String {
    return "CredentialsDTO{email='$email', password='$password'}"
  }
}
