name := "$name$"

lazy val scala313 = "3.1.3"
lazy val scala2138 = "2.13.8"
lazy val supportedScalaVersions = List(scala313, scala2138)

scalacOptions in (Compile, doc) ++= Seq(
  "-no-link-warnings" // Suppresses problems with Scaladoc @throws links
)

// Release / Publish definitions
ThisBuild / organization         := "com.openelectrons"
ThisBuild / scalaVersion         := "3.1.3"

lazy val root = project.in(file("."))
  .dependsOn($module1$, $module2$)
  .aggregate($module1$, $module2$)
  .settings(
    // crossScalaVersions must be set to Nil on the aggregating project
    crossScalaVersions := Nil,
    publish / skip := true
  )

lazy val $module1$ = (project in file("$module1$"))

lazy val $module2$ = (project in file("$module2$"))

