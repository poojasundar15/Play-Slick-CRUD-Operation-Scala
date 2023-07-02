package controllers

import javax.inject.Inject
import model.{User, Users}
import scala.concurrent.Future

class UserAction @Inject() (actions : Users)
{
  def addUserAction(action : User): Future[Unit] ={
    actions.addUser(action)
  }

  def deleteUserAction(id : Int): Future[String] ={
    actions.deleteUser(id)
  }

  def fetchUserById(id : Int): Future[Option[User]] ={
    actions.fetchUserById(id)
  }

  def viewAllAction: Future[List[User]] = actions.viewAllUsers

}
