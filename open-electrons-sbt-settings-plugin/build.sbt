// Define Scala versions
lazy val scala3 = "3.4.0"
lazy val scala2 = "2.12.20"
lazy val supportedScalaVersions = List(scala3, scala2)

// Root project definition
lazy val root = (project in file("."))
  .settings(
      name := "open-electrons-sbt-settings",         // Set project name
      organization := "com.open-electrons",          // Organization
      version := "1.0.0",                            // Project version
      sbtPlugin := true,                             // SBT Plugin (if you're creating one)

      // Cross-building support
      crossScalaVersions := supportedScalaVersions,  // List of Scala versions to build for
      scalaVersion := scala2,                        // Default Scala version for this build

      // Add Scala-specific settings if needed
      scalacOptions ++= Seq(
          "-deprecation",     // Warn about deprecated APIs
          "-feature",         // Warn about misused language features
          "-unchecked",       // Enable additional runtime checks
          "-Xfatal-warnings", // Fail on warnings
          "-encoding", "utf8" // Specify file encoding
      ),

      // Custom settings for Scala 2.x or Scala 3.x (if needed)
      libraryDependencies ++= {
          if (scalaVersion.value == scala2) {
              Seq(
                  "org.scala-lang" % "scala-library" % scala2,
                  // Add Scala 2 specific dependencies here
              )
          } else {
              Seq(
                  "org.scala-lang" % "scala3-library_3" % scala3,
                  // Add Scala 3 specific dependencies here
              )
          }
      }
  )
