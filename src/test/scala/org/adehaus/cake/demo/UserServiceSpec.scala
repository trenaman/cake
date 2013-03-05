package org.adehaus.cake.demo

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import org.mockito.Mockito._

class UserServiceSpec extends FlatSpec with ShouldMatchers with TestComponentRegistry {

  "???" should "!!!" in {
    val userService = new UserServiceImpl

    when(userRepository.getUserPassword("ade")).thenReturn("eda")

    userService.authenticate("ade", "eda") should be (true)
  }
}
