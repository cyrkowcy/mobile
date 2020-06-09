package pl.edu.pk.mobile.tourtool.service.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pl.edu.pk.mobile.tourtool.service.model.Email
import pl.edu.pk.mobile.tourtool.service.model.Name
import pl.edu.pk.mobile.tourtool.service.model.Password

data class UserDTO(
  @SerializedName("firstName")
  @Expose
  val firstName: Name,
  @SerializedName("lastName")
  @Expose
  val lastName: Name,
  @SerializedName("email")
  @Expose
  val email: Email,
  @SerializedName("password")
  @Expose
  val password: Password
) {
  override fun toString(): String {
    return "UserDTO(firstName='$firstName', lastName='$lastName', email='$email', password='$password')"
  }
}
