package prat

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(val firstName: String,
                val lastName: String,
                val phoneNumber: String) {
  @Id
  private val id: String? = null
}