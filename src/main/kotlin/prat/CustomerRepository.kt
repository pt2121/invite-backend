package prat

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pt2121 on 12/7/15.
 */
interface CustomerRepository : MongoRepository<Customer, String> {

  fun findByFirstName(firstName: String): Customer
  fun findByLastName(lastName: String): List<Customer>

}
