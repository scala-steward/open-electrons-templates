name := "open-electrons-templates"

ThisBuild / version := "0.0.1"
ThisBuild / organization := "com.openelectrons"
ThisBuild / scalaVersion := "2.13.16"

// Enable all subprojects to be published to GitHub Packages
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

/*
val publishSettings = Seq(
  publishTo := sonatypePublishToBundle.value,
  sonatypeCredentialHost := "s01.oss.sonatype.org",
  scmInfo := Some(ScmInfo(
    url("https://github.com/joesan/open-electrons/open-electrons-templates"),
    "scm:git@github.com:joesan/ocpp-scala.git"
  )),
  description := "Scala library for Open Charge Point Protocol (OCPP)",
  licenses := Seq("GPLv3" -> new URL("https://www.gnu.org/licenses/gpl-3.0.en.html")),
  homepage := Some(url("https://github.com/joesan/ocpp-scala")),
  developers := List(
    Developer(id="joesan", name="Joesan", email="https://bigelectrons.com", url=url("https://github.com/joesan"))
  )
) */

lazy val openElectronsTemplate = (project in file("."))
  .aggregate(openElectronsScalaFmtSbtPlugin, openElectronsSbtSettingsPlugin, openElectronsSBTTemplate, openElectronsSBTTemplateMultiModule)
  //.disablePlugins(HeaderPlugin)
  .settings(
    // crossScalaVersions must be set to Nil on the aggregating project
    crossScalaVersions := Nil,
    publish / skip := true
  )

lazy val openElectronsScalaFmtSbtPlugin = (project in file("open-electrons-scala-formatter-sbt-plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "openelectrons-scalafmt",
    organization := "com.openelectrons",
    //scalaVersion := "2.13.16",
    sbtPlugin := true,
    //version := "0.0.1",
    publish / skip := false
  ).settings(gitHubPublishSettings: _*)

lazy val openElectronsSbtSettingsPlugin = (project in file("open-electrons-sbt-settings-plugin"))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "openelectrons-sbt-settings",
    // Define Scala versions, sbt plugin requires to use Scala 2.12
    // @see https://stackoverflow.com/questions/79301797/sbt-plugin-error-when-cross-compiling-scala-versions?noredirect=1#comment139842520_79301797
    organization := "com.openelectrons",           // Organization
    //version := "0.0.1",                            // Project version
    //scalaVersion := "2.13.16",
    sbtPlugin := true,
    publish / skip := false
  ).settings(gitHubPublishSettings: _*)

// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details on this temaplate.
lazy val openElectronsSBTTemplate = (project in file("open-electrons-sbt-template.g8"))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "openelectrons-sbt-template",
    publish / skip := true,
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
  )

// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val openElectronsSBTTemplateMultiModule = (project in file("open-electrons-sbt-template-multi-module.g8"))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "openelectrons-sbt-template-multi-module",
    publish / skip := true,
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-XX:MaxPermSize=256m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
  )


// Project g8 templates
//lazy val openElectronsSBTTemplate = project.in(file("open-electrons-templates--sbt-template.g8"))
//lazy val openElectronsSBTTemplateMultiModule = project.in(file("open-electrons-templates-sbt-template-multi-module.g8"))
