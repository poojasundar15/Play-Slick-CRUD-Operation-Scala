package controllers

import model.User
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import play.api.libs.json._

import javax.inject.Inject

class UserJsonFormat @Inject() (
  conCom : ControllerComponents ) extends AbstractController(conCom)
{
  implicit val userjsonFormat =  Json.format[User]

  def getAll: Action[AnyContent] = Action{
    val user = new User(2,"Pooja","Sundar",Some("9786669855"))
    Ok(Json.toJson(user))
  }



}
