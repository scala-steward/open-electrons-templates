import sbt._
import Keys._

object MyPlugin extends AutoPlugin {
  override def trigger: PluginTrigger = allRequirements

  override def globalSettings: Seq[Setting[_]] = Seq(
    resolvers ++= SharedSettings.sharedResolvers
  ) ++ SharedSettings.projectMetadata

  override def projectSettings: Seq[Setting[_]] = Seq(
    // Example task for debugging the resolvers
    SharedSettings.logScalacOptions
  )
}