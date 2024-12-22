// Set of supported Scala versions
lazy val scala3 = "3.4.0"
lazy val scala2 = "2.13.15"
lazy val supportedScalaVersions = List(scala3, scala2)

// This iss for Scala 2.13
scalacOptions ++= Seq(
  "-no-link-warnings", // Suppresses problems with Scaladoc @throws links
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros", // Allow macro definition (besides implementation and application)
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint:adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Xlint:constant", // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select", // Selecting member of DelayedInit.
  "-Xlint:doc-detached", // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible", // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any", // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Xlint:nullary-unit", // Warn when nullary methods return Unit.
  "-Xlint:option-implicit", // Option.apply used implicit view.
  "-Xlint:package-object-classes", // Class or object defined in package object.
  "-Xlint:poly-implicit-overload", // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow", // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align", // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow", // A local type parameter shadows a type already in scope.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
  "-Ywarn-unused:imports", // Warn if an import selector is not referenced.
  "-Ywarn-unused:locals", // Warn if a local definition is unused.
  "-Ywarn-unused:params", // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
  "-Ywarn-unused:privates", // Warn if a private member is unused.
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
  "-Ybackend-parallelism", "8", // Enable paralellisation — change to desired number!
  "-Ycache-plugin-class-loader:last-modified", // Enables caching of classloaders for compiler plugins
  "-Ycache-macro-class-loader:last-modified", // and macro definitions. This can lead to performance improvements.
)

// Release / Publish definitions
ThisBuild / scalaVersion         := scala3

// High-Level Project Details and Configurations
ThisBuild / organization := "com.openelectrons"                                  // Organization name
ThisBuild / scalaVersion := scala3                                               // Scala version
ThisBuild / version := "0.0.1"                                                   // Project version
ThisBuild / name := "open-electrons-sbt-template"                                // Project name
ThisBuild / description := "common settings for open-electrons projects"         // Description
ThisBuild / startYear := Some(2022)                                              // Start year
ThisBuild / homepage := Some(url("hhttps://open-electrons.github.io/home/"))     // Homepage URL
ThisBuild / licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")) // License
ThisBuild / developers := List(                                                  // Developers
  Developer(
    id = "joesan",
    name = "Joesan",
    url = url("https://github.com/joesan")
  )
)
ThisBuild / scmInfo := Some(                                 // Source control info
  ScmInfo(
    browseUrl = url("hhttps://github.com/open-electrons)
  )
)

// Dependency resolvers
ThisBuild / resolvers ++= Seq(
  Resolver.mavenCentral,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

// Compile options
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",     // Warn about deprecated APIs
  "-feature",         // Warn about misused language features
  "-unchecked",       // Enable additional runtime checks
  "-encoding", "utf8" // Specify file encoding
)

// Publishing configuration
ThisBuild / publishTo := {
  if (isSnapshot.value)
    Some("Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true
ThisBuild / credentials += Credentials(
  "Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  "<username>",
  "<password>"
)

// Cross-Scala versions (if needed for cross-building)
ThisBuild / crossScalaVersions := Seq(Scala2, Scala3)
