package com.openelectrons.sbtplugins

import sbt._

object OpenElectronsScalaFmtPlugin extends AutoPlugin {

  val commonScalaFormatConfig: String =
    """
      |version = 3.6.1
      |runner.dialect = scala213source3
      |
      |project.git = true
      |preset = default
      |
      |align.preset = none
      |align.tokens = [
      |  {code = "<-"},
      |]
      |
      |docstrings.style = keep
      |maxColumn = 120
      |
      |rewrite.rules = [
      |  SortImports,
      |  AvoidInfix,
      |]
      |
      |spaces.inImportCurlyBraces = true
      |includeNoParensInSelectChains = false
      |trailingCommas = preserve
      |
      |continuationIndent {
      |  callSite = 2
      |  defnSite = 2
      |  extendSite = 2
      |}
      |
      |optIn {
      |  forceBlankLineBeforeDocstring = false
      |}
      |
      |newlines {
      |  source = keep
      |  afterCurlyLambdaParams = preserve
      |  beforeCurlyLambdaParams = multilineWithCaseOnly
      |  topLevelBodyIfMinStatements = []
      |}
      |""".stripMargin

  override def trigger = allRequirements
  override def requires = plugins.JvmPlugin
  override def buildSettings: Seq[Def.Setting[_]] = {
    SettingKey[Unit]("scalafmtGenerateConfig") :=
      IO.write(
        // writes to file once when build is loaded
        file(".scalafmt-common.conf"), commonScalaFormatConfig.stripMargin.getBytes("UTF-8")
      )
  }
}
