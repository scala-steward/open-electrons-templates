import sbt._
import Keys._

object SharedSettings {

  // Scala Versions
  val scala3 = "3.4.0"
  val scala2 = "2.13.15"
  val supportedScalaVersions = Seq(scala3, scala2)

  // This is for Scala 2.13
  val scalacOptionsScala2 = Seq(
    "-no-link-warnings", // Suppress Scaladoc @throws warnings
    "-deprecation", // Emit warnings for deprecated APIs
    "-explaintypes", // Provide detailed type errors
    "-feature", // Warn about misused language features
    "-language:existentials", // Allow existential types
    "-language:experimental.macros", // Enable macro definitions
    "-language:higherKinds", // Allow higher-kinded types
    "-language:implicitConversions", // Allow implicit functions (views)
    "-unchecked", // Enable additional warnings for assumptions in generated code
    "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access
    "-Xfatal-warnings", // Fail compilation if any warnings
    "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver
    "-Xlint:constant", // Warn if constant evaluation leads to errors
    "-Xlint:delayedinit-select", // Warn if DelayedInit member is selected
    "-Xlint:doc-detached", // Warn if Scaladoc comment is detached
    "-Xlint:inaccessible", // Warn about inaccessible types
    "-Xlint:infer-any", // Warn when a type argument is inferred to be Any
    "-Xlint:missing-interpolator", // Warn if string literal lacks interpolator
    "-Xlint:nullary-override", // Warn if non-nullary def overrides nullary def
    "-Xlint:nullary-unit", // Warn if nullary methods return Unit
    "-Xlint:option-implicit", // Warn about Option.apply used as an implicit view
    "-Xlint:package-object-classes", // Warn about class/object in package object
    "-Xlint:poly-implicit-overload", // Warn about parameterized implicit overloads
    "-Xlint:private-shadow", // Warn if private field shadows a superclass field
    "-Xlint:stars-align", // Warn about misaligned wildcard in pattern matching
    "-Xlint:type-parameter-shadow", // Warn if type parameter shadows an existing type
    "-Ywarn-dead-code", // Warn about dead code
    "-Ywarn-extra-implicit", // Warn about extra implicit parameters
    "-Ywarn-numeric-widen", // Warn about numeric widening
    "-Ywarn-unused:implicits", // Warn about unused implicits
    "-Ywarn-unused:imports", // Warn about unused imports
    "-Ywarn-unused:locals", // Warn about unused locals
    "-Ywarn-unused:params", // Warn about unused parameters
    "-Ywarn-unused:patvars", // Warn about unused pattern variables
    "-Ywarn-unused:privates", // Warn about unused private members
    "-Ywarn-value-discard", // Warn if non-Unit expression is unused
    "-Ybackend-parallelism", "8", // Enable parallelism for backend operations
    "-Ycache-plugin-class-loader:last-modified", // Enable plugin classloader caching
    "-Ycache-macro-class-loader:last-modified" // Enable macro classloader caching
  )

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


  // Compile options
  val compileOptions = Seq(
    "-deprecation",          // Warn about deprecated APIs
    "-feature",              // Warn about misused language features
    "-unchecked",            // Enable additional runtime checks
    "-Xfatal-warnings",      // Fail on warnings
    "-encoding", "utf8",     // Specify file encoding
    "-Xignore-scala2-macros" // Ignore Scala 2 macros
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

  // Cross-Scala versions (if needed for cross-building)
  //val crossScalaVersions = Seq(scala2, scala3)

  // Final Shared Settings
  val settings: Seq[Setting[_]] = projectMetadata ++ Seq(
    ThisBuild / scalacOptions := scalacOptionsScala2,
    //resolvers := resolvers.value ++ resolversSetting,
    //ThisBuild / resolvers ++= dependencyResolvers,
    ThisBuild / scalacOptions ++= compileOptions,
    //ThisBuild / crossScalaVersions := crossScalaVersions
  ) ++ publishingConfig
}
