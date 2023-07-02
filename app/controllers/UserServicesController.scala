package controllers

//import akka.actor.Status.Success
//import akka.http.impl.util.JavaMapping.StatusCode
import model.{User, UserForm}
import play.api.libs.json.Json
import play.api.mvc._
import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class UserServicesController @Inject()
(conCom: ControllerComponents,
 userAction: UserAction) extends AbstractController(conCom) {
  implicit val userFormat = Json.format[User]

  def addUser(): Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent] =>
      UserForm.form.bindFromRequest().fold(
        errorForm => {
          errorForm.errors.foreach(println)
          Future.successful(BadRequest("Added user Failed!"))
        },
        data => {
          val newUser = User(data.id, data.fName, data.lName, data.mobile)
          userAction.addUserAction(newUser).map(_ => Redirect(routes.UserServicesController.getAllUsers()))
        })
  }


  def delete(id:Int): Action[AnyContent] = Action.async {
    implicit request : Request[AnyContent] =>
      userAction.deleteUserAction(id) map {
        res => Redirect(routes.UserServicesController.getAllUsers())
      }
  }

  def fetchUserById(id: Int): Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent] =>
      userAction.fetchUserById(id) map { action =>
        Ok(Json.toJson(action))
      }
  }

  def getAllUsers(): Action[AnyContent] = Action.async {
    implicit request: Request[AnyContent] =>
      userAction.viewAllAction map { actions =>
        Ok(Json.toJson(actions))
      }
  }
}
