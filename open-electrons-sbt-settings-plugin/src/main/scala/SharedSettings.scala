import sbt._
import Keys._

object SharedSettings {

  // Scala Versions
  val scala3 = "3.4.0"
  val scala2 = "2.13.15"
  val supportedScalaVersions = Seq(scala3, scala2)

  // Prints the used scala compiler options
  // Usage: sbt logScalacOptions
  lazy val logScalacOptions = taskKey[Unit]("Log scalacOptions for debugging")
  logScalacOptions := {
    streams.value.log.info(s"scalacOptions: ${scalacOptions.value.mkString(", ")}")
  }

  // High-Level Project Details and Configurations
  val projectMetadata = Seq(
    ThisBuild / organization := "com.openelectrons", // Organization name
    ThisBuild / scalaVersion := scala3, // Scala version
    ThisBuild / version := "0.0.1", // Project version
    ThisBuild / name := "open-electrons-sbt-template", // Project name
    ThisBuild / description := "common settings for open-electrons projects", // Description
    ThisBuild / startYear := Some(2022), // Start year
    ThisBuild / homepage := Some(url("https://open-electrons.github.io/home/")), // Homepage URL
    ThisBuild / licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")), // License
    ThisBuild / developers := List( // Developers
      Developer(
        id = "joesan",
        name = "Joesan",
        email = "https://bigelectrons.com/",
        url = url("https://github.com/joesan")
      )
    ),
    ThisBuild / scmInfo := Some(
      ScmInfo(
        browseUrl = url("https://github.com/open-electrons/open-electrons-sbt-template"),
        connection = "scm:git:https://github.com/open-electrons/open-electrons-sbt-template.git",
        devConnection = Some("scm:git:https://github.com/open-electrons/open-electrons-sbt-template.git")
      )
    )
  )

  // Dependency resolvers
  ThisBuild / resolvers ++= Seq(
    Resolver.mavenCentral,
    "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
    "Typesafe Snapshots" at "https://repo.typesafe.com/typesafe/snapshots/"
  ) ++ Resolver.sonatypeOssRepos("snapshots") ++ Resolver.sonatypeOssRepos("releases")

  // Publishing configuration
  val publishingConfig = Seq(
    ThisBuild / publishTo := {
      if (isSnapshot.value)
        Some("Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
      else
        Some("Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
    },
    ThisBuild / publishMavenStyle := true,
    ThisBuild / credentials += Credentials(
      "Sonatype Nexus Repository Manager",
      "oss.sonatype.org",
      "<username>",
      "<password>"
    )
  )

  // Final Shared Settings
  val settings: Seq[Setting[_]] = projectMetadata ++ publishingConfig
}
