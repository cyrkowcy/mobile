package pl.edu.pk.mobile.tourtool.service.model

data class User(
  val firstName: Name,
  val lastName: Name,
  val email: Email,
  val password: Password
)
