package prat

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class User(@JsonProperty("firstName") val firstName: String,
                @JsonProperty("lastName") val lastName: String,
                @JsonProperty("phoneNumber") val phoneNumber: String)
//{
//  @Id
//  @JsonProperty("_id")
//  private val id: String? = null
//}