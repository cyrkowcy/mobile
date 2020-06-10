package pl.edu.pk.mobile.tourtool.service.model

data class UserResponse(
  val firstName: String,
  val lastName: String,
  val email: String,
  val disabled: Boolean,
  val roles: Array<String>,
  val createDate: String
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as UserResponse

    if (firstName != other.firstName) return false
    if (lastName != other.lastName) return false
    if (email != other.email) return false
    if (disabled != other.disabled) return false
    if (!roles.contentEquals(other.roles)) return false
    if (createDate != other.createDate) return false

    return true
  }

  override fun hashCode(): Int {
    var result = firstName.hashCode()
    result = 31 * result + lastName.hashCode()
    result = 31 * result + email.hashCode()
    result = 31 * result + disabled.hashCode()
    result = 31 * result + roles.contentHashCode()
    result = 31 * result + createDate.hashCode()
    return result
  }
}
