package hello

import org.springframework.data.annotation.Id

data class User(val firstName: String,
                val lastName: String,
                val phoneNumber: String) {
  @Id
  private val id: String? = null
}