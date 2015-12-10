package prat

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(@JsonProperty("firstName") val firstName: String,
                @JsonProperty("lastName") val lastName: String,
                @JsonProperty("phoneNumber") val phoneNumber: String) {
  @Id
  private val id: String? = null
}