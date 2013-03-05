package org.adehaus.cake.demo

trait Config {
  def dbUrl: String
}

trait ConfigComponent {
  val config: Config

  class ConfigImpl extends Config {
    def dbUrl = "jdbc://hola-senor"
  }
}

trait UserRepository {
  def getUserPassword(username: String): String
}

trait UserRepositoryComponent {
  self: ConfigComponent =>

  val userRepository: UserRepository

  class UserRepositoryImpl extends UserRepository {
    println("Initializing the user repository with db " + config.dbUrl)

    def getUserPassword(username: String) = {
      username
    }
  }
}

trait UserService {
  def authenticate(username:String, password: String): Boolean
}

trait UserServiceComponent {
  this: UserRepositoryComponent =>

  val userService: UserService

  class UserServiceImpl extends UserService {
    def authenticate(username: String, password: String) = {
      val actualPassword = userRepository.getUserPassword(username)
      password == actualPassword
    }
  }
}

trait ComponentRegistry
  extends UserRepositoryComponent
  with UserServiceComponent
  with ConfigComponent
{
  println("Initializign the config")
  val config = new ConfigImpl

  println("Creating the user service")
  val userService = new UserServiceImpl

  println("Creating the userRepository")
  val userRepository = new UserRepositoryImpl
}

