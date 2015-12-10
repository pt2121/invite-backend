package prat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by pt2121 on 12/8/15.
 */
@RestController
@RequestMapping("/invites")
class InviteController {

  @Autowired
  private val inviteRepository: InviteRepository? = null

  @RequestMapping(method = arrayOf(RequestMethod.GET))
  fun getAll(): List<Invite> {
    return inviteRepository!!.findAll()
  }

  @RequestMapping(method = arrayOf(RequestMethod.GET), value = "{id}")
  fun getOne(@PathVariable("id") id: String): Invite {
    return inviteRepository!!.findOne(id)
  }

  //http://localhost:8080/invites?dLatLng=40.750572,-73.9957077
  @RequestMapping(method = arrayOf(RequestMethod.GET), params = arrayOf("dLatLng"))
  fun getByLatLng(@RequestParam(value = "dLatLng") latLng: String): Invite {
    return inviteRepository!!.findByDestinationLatLng(latLng).first()
  }

  @RequestMapping(method = arrayOf(RequestMethod.POST))
  fun create(@RequestBody invite: Invite): Invite {
    return inviteRepository!!.save(invite)
  }

  @RequestMapping(method = arrayOf(RequestMethod.PUT), value = "{id}")
  fun update(@RequestBody invite: Invite): Invite {
    return inviteRepository!!.save(invite)
  }

  @RequestMapping(method = arrayOf(RequestMethod.DELETE), value = "{id}")
  fun delete(@PathVariable id: String) {
    inviteRepository!!.delete(id)
  }
}
