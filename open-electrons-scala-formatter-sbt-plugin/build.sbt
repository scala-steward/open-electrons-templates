lazy val sbtCommonFormatterPlugin = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "openelectrons-scalafmt",
    version := "0.0.1",
    organization := "com.openelectrons",
    scalaVersion := "2.12.17",
    sbtPlugin := true,
    sbtVersion := "1.6.2"
  )
