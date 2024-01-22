addSbtPlugin("com.github.sbt" % "sbt-release" % "1.4.0")
// To add license headers to source file
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.10.0")
addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8" % "0.16.2")

libraryDependencies += { "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value }