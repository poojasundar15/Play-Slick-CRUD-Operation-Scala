package model

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.lifted.TableQuery
import slick.jdbc.MySQLProfile.api._
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.{ExecutionContext, Future}

class Users @Inject()(protected val dbConfigProvider : DatabaseConfigProvider)
                       (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile]
  {
    var users = TableQuery[UserTable]

    def addUser(user: User): Future[Unit] = {
      dbConfig.db.run(users += user)
        .map(_=> ())
    }

    def deleteUser(id:Int): Future[String] ={
      dbConfig.db.run(users.filter(_.id === id).delete)
        .map(_ => "Delete the user successfully")
    }


    def fetchUserById(id:Int): Future[Option[User]] = {
      dbConfig.db.run(users.filter(_.id === id).result.headOption)
    }

    def viewAllUsers: Future[List[User]] = dbConfig.db.run(users.result).map(_.toList)
  }
