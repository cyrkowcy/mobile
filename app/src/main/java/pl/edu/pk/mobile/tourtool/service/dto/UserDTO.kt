package pl.edu.pk.mobile.tourtool.service.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDTO(
  @SerializedName("firstName")
  @Expose
  val firstName: String,
  @SerializedName("lastName")
  @Expose
  val lastName: String,
  @SerializedName("email")
  @Expose
  val email: String,
  @SerializedName("password")
  @Expose
  val password: String
) {
  override fun toString(): String {
    return "UserDTO(firstName='$firstName', lastName='$lastName', email='$email', password='$password')"
  }
}
