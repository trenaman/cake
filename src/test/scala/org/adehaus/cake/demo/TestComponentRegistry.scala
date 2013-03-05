package org.adehaus.cake.demo

import org.scalatest.mock.MockitoSugar

trait TestComponentRegistry
  extends UserRepositoryComponent
  with UserServiceComponent
  with ConfigComponent
  with MockitoSugar
{
  println("Initializign the config")
  val config = mock[Config]

  println("Creating the user service")
  val userService = mock[UserService]

  println("Creating the userRepository")
  val userRepository = mock[UserRepository]
}
