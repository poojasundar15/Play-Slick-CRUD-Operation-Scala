package model

import play.api.data.Form
import play.api.data.Forms._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape

object UserForm {
  val form = Form(
    mapping(
      "id" -> number,
      "fName" -> nonEmptyText,
      "lName" -> nonEmptyText,
      "mobile" -> optional(text))
    (User.apply)(User.unapply)
  )
}

class UserTable(tag: Tag) extends Table[User](tag, "userTable") {

  def id: Rep[Int] = column[Int]("ID")

  def fName: Rep[String] = column[String]("FName")

  def lName: Rep[String] = column[String]("LName")

  def mobile: Rep[Option[String]] = column[Option[String]]("Mobile")

  override def * : ProvenShape[User] = (id, fName, lName, mobile) <> (User.tupled, User.unapply)
}
