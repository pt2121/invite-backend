package prat

import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by pt2121 on 12/8/15.
 */
interface InviteRepository : MongoRepository<Invite, String> {
  fun findByLatLng(latLng: String): List<Invite>
  fun findByFrom(from: User): List<Invite>
  fun findByTo(from: User): List<Invite>
}