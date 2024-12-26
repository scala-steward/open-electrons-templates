import sbt._
import Keys._

object MyPlugin extends AutoPlugin {
  override def trigger: PluginTrigger = allRequirements

  override def globalSettings: Seq[Setting[_]] = Seq(
    resolvers ++= SharedSettings.sharedResolvers
  ) ++ SharedSettings.projectMetadata

  // Add project-specific settings and tasks
  override def projectSettings: Seq[Setting[_]] = Seq(
    // Define a task for logging scalacOptions
    SharedSettings.logScalacOptions := {
      streams.value.log.info(s"scalacOptions: ${scalacOptions.value.mkString(", ")}")
    }
  )
}