import sbt._
import Keys._

object SharedSettings {

  // Scala Versions
  lazy val scala3_4_0 = "3.4.0"

  // Prints the used scala compiler options
  // Usage: sbt logScalacOptions
  lazy val logScalacOptions = taskKey[Unit]("Log scalacOptions for debugging")
  logScalacOptions := {
    streams.value.log.info(s"scalacOptions: ${scalacOptions.value.mkString(", ")}")
  }

  // Dependency resolvers
  val sharedResolvers: Seq[Resolver] = Seq(
    Resolver.mavenCentral,
    "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
    "Typesafe Snapshots" at "https://repo.typesafe.com/typesafe/snapshots/",
    "GitHub Packages" at "https://maven.pkg.github.com/open-electrons/open-electrons-templates"
  ) ++ Resolver.sonatypeOssRepos("snapshots") ++ Resolver.sonatypeOssRepos("releases")

  // High-Level Project Details and Configurations
  val projectMetadata = Seq(
    organization := "com.openelectrons", // Organization name
    scalaVersion := scala3_4_0, // Scala version
    description := "common settings for open-electrons projects", // Description
    startYear := Some(2022), // Start year
    homepage := Some(url("https://open-electrons.github.io/home/")), // Homepage URL
    licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")), // License
    developers := List( // Developers
      Developer(
        id = "joesan",
        name = "Joesan",
        email = "https://bigelectrons.com/",
        url = url("https://github.com/joesan")
      )
    ),
    scmInfo := Some(
      ScmInfo(
        browseUrl = url("https://github.com/open-electrons/open-electrons-sbt-template"),
        connection = "scm:git:https://github.com/open-electrons/open-electrons-sbt-template.git",
        devConnection = Some("scm:git:https://github.com/open-electrons/open-electrons-sbt-template.git")
      )
    )
  )

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

  lazy val gitHubPublishSettings = Seq(
    publishMavenStyle := true,
    publishTo := Some("GitHub Packages" at "https://maven.pkg.github.com/open-electrons/open-electrons-templates"),
    credentials += Credentials(
      "GitHub Package Registry",
      "maven.pkg.github.com",
      "joesan",
      sys.env.get("GITHUB_TOKEN").getOrElse("will-be-fetched-via-github-env")
    )
  )

  // Final Shared Settings
  val settings: Seq[Setting[_]] = projectMetadata ++ gitHubPublishSettings ++ publishingConfig ++ Seq(
    resolvers ++= sharedResolvers
  )
}
