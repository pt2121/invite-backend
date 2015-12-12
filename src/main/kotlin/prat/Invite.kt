package prat

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by pt2121 on 12/8/15.
 */
@Document
data class Invite(@JsonProperty("from") val from: User,
                  @JsonProperty("to") val to: User,
                  @JsonProperty("destinationLatLng") val destinationLatLng: String,
                  @JsonProperty("destinationAddress") val destinationAddress: String,
                  @JsonProperty("message") val message: String,
                  @JsonProperty("status") val status: Status,
                  @JsonProperty("pickupAddress") val pickupAddress: String) { // somehow Spring failed when adding a default value here
  @Id
  @JsonProperty("_id")
  private val id: String? = null
}

enum class Status {
  PENDING, ACCEPT, REJECT, CANCEL
}