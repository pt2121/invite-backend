package prat

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pt2121 on 12/8/15.
 */

interface UserRepository : MongoRepository<User, String> {

  fun findByPhoneNumber(phoneNumber: String): User
  fun findByFirstName(firstName: String): List<User>
  fun findByLastName(lastName: String): List<User>

}