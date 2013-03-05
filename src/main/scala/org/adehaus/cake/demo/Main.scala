package org.adehaus.cake.demo

object Main extends ComponentRegistry {
  def main(args: Array[String]) {
    println("Hello, World.")
    userService.authenticate("ade", "eda")
  }
}