# Play Framework with slick -  CRUD Operations!

This is a Simple project of Crud operations in Scala using **Play framework** with **Slick** database **MySql**.

## Basics of  Procedure of web API with Scala Play Framework

-   Create a web API project.
-   Add a model class and a database context.
-   Create a controller with CRUD methods.
-   Configure routing, URL paths, and return values.
-   Call the web API with Postman.

## Prerequisites :-

* SBT.Version = 1.4.6
* Scala = 2.13.8
* Play Framework = 2.8.14 (Play works only on Java 8 to 11).

## Creating a New Project with Play

Play expects a specific project structure. If you already have [sbt](https://www.scala-sbt.org/1.x/docs/Setup.html), you can use a template to create a new Play project. This gives you a proper structure of project folders and development environment.

**Scala template - To install play and Sample project**
>  sbt new playframework/play-scala-seed.g8

## Create a web project

Open a command prompt,

Run the following command and respond to the prompts to create a new project template.

 - `name [Project Name]: sampleproject`
 - `organization [org Name]: com.qbrainx`
 - `play_version [2.8.15] : 2.8.15`
 - `scala_version [2.13.8] : 2.13.8`

A new folder is created named `sampleproject` that contains the minimal project template contents.

## 1 . Adding Dependencies

Here, the following dependencies for the project **`build.sbt`**

- `libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.0.0"`
- `libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.28"`

## 2 . plugins.sbt

`addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.14")`

## 3. application.conf

`slick.dbs.default.profile = "slick.jdbc.MySQLProfile$"`  
`slick.dbs.default.db.driver = "com.mysql.cj.jdbc.Driver"`  
`slick.dbs.default.db.url = "jdbc:mysql://localhost/playSlick"`
`slick.dbs.default.db.user ="root" `
`slick.dbs.default.db.password = "admin"`

## Routes

**`We have added new methods to our API. Let’s add routes for all API method`**
- GET /json  -  controllers.UserJsonFormat.getAll
- GET /allUsers   -  controllers.UserServicesController.getAllUsers()
- GET /fetchUserById/:id - controllers.UserServicesController.fetchUserById(id:Int)
- POST /add   - controllers.UserServicesController.addUser()
- DELETE /delete/:id  -  controllers.UserServicesController.delete(id :
  Int)

## Demo Output(postman) :-

I have exported `sampleproject` outputs in [postman](https://www.postman.com/) collection.

Click here for reference [sample postman output.](postman/PlaySlick%20copy.postman_collection.json)
