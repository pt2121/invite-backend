package prat

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by pt2121 on 12/8/15.
 */
@Document
data class Invite(@DBRef val from: User,
                  @DBRef val to: User,
                  val latLng: String,
                  val address: String,
                  val message: String) {
  @Id
  private val id: String? = null
}

