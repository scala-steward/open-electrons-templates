package com.openelectrons.sbtplugins

import sbt._
import Keys._

object OpenElectronsScalaFmtPlugin extends AutoPlugin {
  override def trigger = allRequirements
  override def requires = plugins.JvmPlugin
  override def buildSettings: Seq[Def.Setting[_]] = {
    SettingKey[Unit]("scalafmtGenerateConfig") :=
      IO.write(
        // writes to file once when build is loaded
        file(".scalafmt-common.conf"),
        ("version = 3.6.1\n" +
          "runner.dialect = scala213source3\n\n" +
          "project.git = true\n" +
          "preset = default\n\n" +
          "align.preset = none\n" +
          "align.tokens = [\n" +
          "  {code = \"<-\"},\n" +
          "]\n\n" +
          "docstrings.style = keep\n" +
          "maxColumn = 120\n\n"
          ).stripMargin.getBytes("UTF-8")
      )
  }
}
