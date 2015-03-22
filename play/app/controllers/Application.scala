package controllers

import com.example.models.entity.Person
import play.libs.Json
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test = Action {
    val test = new Person {
      {
        setId(100)
        setName("John")
        setDescription("Who am I?")
      }
    }
    Ok(Json.toJson(test).toString)
  }
}