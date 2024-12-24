// Define Scala versions, sbt plugin requires to use Scala 2.12
// @see https://stackoverflow.com/questions/79301797/sbt-plugin-error-when-cross-compiling-scala-versions?noredirect=1#comment139842520_79301797
lazy val scala2 = "2.12.20"

// Root project definition
lazy val root = (project in file("."))
  .settings(
      name := "open-electrons-sbt-settings",         // Set project name
      organization := "com.openelectrons",           // Organization
      version := "0.0.1",                            // Project version
      sbtPlugin := true,                             // SBT Plugin (if you're creating one)
      scalaVersion := scala2,                        // Default Scala version for this build

      // Add Scala-specific settings if needed
      scalacOptions ++= Seq(
          "-deprecation",     // Warn about deprecated APIs
          "-feature",         // Warn about misused language features
          "-unchecked",       // Enable additional runtime checks
          "-Xfatal-warnings", // Fail on warnings
          "-encoding", "utf8" // Specify file encoding
      )
  )