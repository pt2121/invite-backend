package hello

import org.springframework.data.annotation.Id

/**
 * Created by pt2121 on 12/7/15.
 */
data class Customer(val firstName: String, val lastName: String) {

  @Id
  private val id: String? = null

  override fun toString(): String {
    return "Customer[id=$id, firstName='$firstName', lastName='$lastName']"
  }

}