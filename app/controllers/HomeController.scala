package controllers

import play.api.mvc._
import javax.inject._

@Singleton
class HomeController @Inject()(val control: ControllerComponents)
  extends AbstractController(control) {

  def index(): Action[AnyContent] = Action { implicit request =>
    sample("Some parameters")
    Ok(views.html.index())
  }

  def sample(p:String): Action[AnyContent] = Action {
    Ok(views.html.sample())
  }
}
