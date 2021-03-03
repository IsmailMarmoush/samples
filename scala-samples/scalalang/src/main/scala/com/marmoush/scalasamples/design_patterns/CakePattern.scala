package com.marmoush.scalasamples.design_patterns

/**
  * http://blog.originate.com/blog/2013/10/21/reader-monad-for-dependency-injection/
  */
object CakePattern {

  def main(args: Array[String]) {
    // Using first impl
    object UserInfoImpl extends UserInfo with UserRepositoryComponentFirstImpl
    println(UserInfoImpl.findUser("f2").email)
    // using another impl
    object UserInfoOtherImpl extends UserInfo with UserRepositoryComponentSecondImpl
    println(UserInfoOtherImpl.findUser("f2").email)
  }

}

case class User(id: Int, firstName: String, lastName: String, email: String, supervisorId: Int)

object DB {

  val users =
    Set(new User(1, "f1", "l1", "email1", 1), new User(2, "f2", "l2", "email2", 1), new User(3, "f3", "l3", "email3", 1))
}

trait UserRepositoryComponent {

  def userRepository: UserRepository

  trait UserRepository {
    def get(id: Int): User

    def find(username: String): User
  }

}

trait Users {
  this: UserRepositoryComponent =>

  def getUser(id: Int): User = {
    userRepository.get(id)
  }

  def findUser(username: String): User = {
    userRepository.find(username)
  }
}

trait UserInfo extends Users {
  this: UserRepositoryComponent =>

  def userEmail(id: Int): String = {
    getUser(id).email
  }

  def userInfo(username: String): Map[String, String] = {
    val user = findUser(username)
    val boss = getUser(user.supervisorId)
    Map("fullName" -> s"${user.firstName} ${user.lastName}",
        "email"    -> s"${user.email}",
        "boss"     -> s"${boss.firstName} ${boss.lastName}")
  }
}

trait UserRepositoryComponentFirstImpl extends UserRepositoryComponent {

  def userRepository = new UserRepositoryImpl

  class UserRepositoryImpl extends UserRepository {

    def get(id: Int) = {
      DB.users.filter(_.id == id).head
    }

    def find(username: String) = {
      DB.users.filter(_.firstName == username).head
    }
  }

}

trait UserRepositoryComponentSecondImpl extends UserRepositoryComponent {

  def userRepository = new UserRepositoryImpl

  class UserRepositoryImpl extends UserRepository {

    def get(id: Int) = {
      DB.users.find(_.id == id).get
    }

    def find(username: String) = {
      DB.users.find(_.firstName == username).get
    }
  }

}
