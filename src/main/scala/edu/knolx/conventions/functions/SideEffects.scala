package edu.knolx.conventions.functions

import scala.collection.mutable.ListBuffer

case class User(username: String, password: String, firstName: String, lastName: String = "")

object UserDataBase{
  val users = ListBuffer.empty[User]
}

case class UserNotFoundException(label: String) extends Exception

object Session{
  def initialize(user: User): User = ???
}

class SideEffects {

  def checkPassword(user: User): Boolean = {
    val username = user.username
    val password = user.password
    val filteredUser = UserDataBase.users.toList.filter(_.username == username)
    require(filteredUser.nonEmpty, "Username Not found")

    filteredUser.filter(_.password == password) match {
      case foundUser :: Nil =>
        Session.initialize(foundUser) // Side effects
        true
      case _ => print("Wrong password")
        false
    }
  }

  def checkPasswordAndInitializeSession(user: User): Boolean = {
    val username = user.username
    val password = user.password
    val filteredUser = UserDataBase.users.toList.filter(_.username == username)
    require(filteredUser.nonEmpty, "Username Not found")

    filteredUser.filter(_.password == password) match {
      case foundUser :: Nil =>
        Session.initialize(foundUser)
        true
      case _ => print("Wrong password")
        false
    }
  }

}

object SideEffectsRefactored{
  def checkPassword(user: User): Boolean = {
    val username = user.username
    val password = user.password
    val filteredUser = UserDataBase.users.toList.filter(_.username == username)
    require(filteredUser.nonEmpty, "Username Not found")

    filteredUser.filter(_.password == password) match {
      case _ :: Nil => true
      case _ => print("Wrong password")
        false
    }
  }

  def login(user: User): User = {
    if(checkPassword(user)){
      Session.initialize(user)
    } else {
      throw UserNotFoundException(user.toString)
    }
  }
}
