import sbt.Keys.{licenses, startYear}

lazy val scala313 = "3.1.3"
lazy val scala2138 = "2.13.8"
lazy val supportedScalaVersions = List(scala313, scala2138)

// Release / Publish definitions
ThisBuild / organization         := "com.openelectrons"
ThisBuild / scalaVersion         := "3.1.3"
// don't publish the outer enclosing project, i.e. "com.openelectrons" % "open-electrons-templates"
ThisBuild / publish / skip       := true
ThisBuild / publishMavenStyle    := true
ThisBuild / publishTo := Some(
  "GitHub Package Registry " at "https://maven.pkg.github.com/open-electrons/oscp-scala"
)
ThisBuild / credentials += Credentials(
  "GitHub Package Registry", // realm
  "maven.pkg.github.com", // host
  "joesan", // user
  sys.env.getOrElse("GITHUB_TOKEN", "abc123") // password
)

/*
val publishSettings = Seq(
  publishTo := sonatypePublishToBundle.value,
  sonatypeCredentialHost := "s01.oss.sonatype.org",
  scmInfo := Some(ScmInfo(
    url("https://github.com/joesan/ocpp-scala"),
    "scm:git@github.com:joesan/ocpp-scala.git"
  )),
  description := "Scala library for Open Charge Point Protocol (OCPP)",
  licenses := Seq("GPLv3" -> new URL("https://www.gnu.org/licenses/gpl-3.0.en.html")),
  homepage := Some(url("https://github.com/joesan/ocpp-scala")),
  developers := List(
    Developer(id="joesan", name="Joesan", email="https://bigelectrons.com", url=url("https://github.com/joesan"))
  )
) */

lazy val openElectronsTemplates = (project in file("."))
  .aggregate(sbtCommonFormatterPlugin)
  .disablePlugins(HeaderPlugin)
  .settings(
    // crossScalaVersions must be set to Nil on the aggregating project
    crossScalaVersions := Nil,
    publish / skip := true
  )

// sbt-common-formatter-plugin is configured in its own build.sbt file
lazy val sbtCommonFormatterPlugin = project

// publishing settings needed at the top level project when running "sonatypeBundleRelease"
sonatypeCredentialHost := "s01.oss.sonatype.org"
sonatypeProfileName := "com.openelectrons"
