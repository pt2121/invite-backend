package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by pt2121 on 12/7/15.
 */
@SpringBootApplication
open class Application : CommandLineRunner {

  @Autowired
  private val repository: CustomerRepository? = null

  @Autowired
  private val inviteRepository: InviteRepository? = null

  @Autowired
  private val userRepository: UserRepository? = null

  @Throws(Exception::class)
  override fun run(vararg args: String) {
    
    repository!!.deleteAll()

    // save a couple of customers
    repository.save(Customer("Alice", "Smith"))
    repository.save(Customer("Bob", "Smith"))

    // fetch all customers
    println("Customers found with findAll():")
    println("-------------------------------")
    for (customer in repository.findAll()) {
      println(customer)
    }
    println()

    // fetch an individual customer
    println("Customer found with findByFirstName('Alice'):")
    println("--------------------------------")
    println(repository.findByFirstName("Alice"))

    println("Customers found with findByLastName('Smith'):")
    println("--------------------------------")
    for (customer in repository.findByLastName("Smith")) {
      println(customer)
    }

    println("-------------------------------")

    inviteRepository!!.deleteAll()
    userRepository!!.deleteAll()

    val alice = User("Alice", "Smiths", "6466445321")
    userRepository.save(alice)
    val katy1 = User("Katy", "Wang", "6465450967")
    userRepository.save(katy1)
    val katy2 = User("Katy", "Jones", "4152393947")
    userRepository.save(katy2)

    val katy = userRepository.findByPhoneNumber("6465450967")
    println("find by phone number: $katy")
    println("-------------------------------")

    val users = userRepository.findByFirstName("Katy")
    users.forEach {
      println("   $it")
    }
    println("-------------------------------")

    inviteRepository.save(Invite(
        alice,
        katy1,
        "40.7248103,-74.0099216",
        "240 Hudson St",
        "Join us!"
    ))

    inviteRepository.save(Invite(
        alice,
        katy1,
        "40.750572,-73.9957077",
        "Pennsylvania Station, New York",
        "See you at Penn Station"
    ))

    inviteRepository.save(Invite(
        katy2,
        alice,
        "40.725626,-74.3059437",
        "Millburn, NJ",
        "Meet at my place?"
    ))

    // fetch all invites
    println("Invites found with findAll():")
    println("-------------------------------")
    inviteRepository.findAll().forEach {
      println(it)
    }
    println()

    println("-------------------------------")
    inviteRepository.findByLatLng("40.750572,-73.9957077").forEach {
      println(it)
    }
    println()

    println("-------------------------------")
    inviteRepository.findByFrom(alice).forEach {
      println(it)
    }
    println()

    println("-------------------------------")
    inviteRepository.findByTo(alice).forEach {
      println(it)
    }
    println()

  }

  companion object {

    @JvmStatic fun main(args: Array<String>) {
      SpringApplication.run(Application::class.java, *args)
    }
  }

}
