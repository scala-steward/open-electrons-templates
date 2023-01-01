name := "open-electrons-templates"

// don't publish the outer enclosing project, i.e. "com.openelectrons" % "ocpp-electrons-templates"
ThisBuild / publish / skip       := true
ThisBuild / publishMavenStyle    := true
ThisBuild / versionScheme        := Some("early-semver")
ThisBuild / publishTo := Some(
  "GitHub Package Registry " at "https://maven.pkg.github.com/open-electrons/ocpp-scala"
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

lazy val openElectronsTemplate = (project in file("."))
  .aggregate(openElectronsScalaFmtSbtPlugin, openElectronsSBTTemplate, openElectronsSBTMultiModuleTemplate)
  //.disablePlugins(HeaderPlugin)
  .settings(
    // crossScalaVersions must be set to Nil on the aggregating project
    crossScalaVersions := Nil,
    publish / skip := true
  )

// sbt-common-formatter-plugin is configured in its own build.sbt file
lazy val openElectronsScalaFmtSbtPlugin = project.in(file("open-electrons-templates--scala-formatter-sbt-plugin"))
// Project templates
lazy val openElectronsSBTTemplate = project.in(file("open-electrons-templates--sbt-template.g8"))
lazy val openElectronsSBTMultiModuleTemplate = project.in(file("open-electrons-templates--sbt-template-multi-module.g8"))
