# open-electrons-templates

Collection of templates, guidelines etc., for all open-electrons projects!

## Installations

### Install Scala

To manually install Scala to a location of your choice in Ubuntu, do the following:

```bash
curl -s https://api.github.com/repos/lampepfl/dotty/releases/latest| grep browser_download_url  | egrep '.tar.gz' | cut -d '"' -f 4 | wget -i -
```

Extract the archive to a location of your choice. I normally do that under /opt/softwares

```bash
tar -xf scala3-*.tar.gz
```

### Install Sbt

To install sbt, refer [here](https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html)

**HINT: Make sure that you have proper compatibility of versions between Scala, Sbt and Java. For more information, refer [here](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html)**

Additionally, this project contains the common-settings.sbt where several common sbt configurations are defined. These need to be imported in each open-electrons project's sbt file as below:

´´´
// The shared settings are stored in a file in the open-electrons-templates repository
val sharedSettingsUrl = "https://github.com/open-electrons/open-electrons-templates/blob/master/common-settings.sbt"
val sharedSettings = Source.fromURL(sharedSettingsUrl).mkString
Project.in(file(".")).settings(sharedSettings.split("\n").map(eval): _*)
´´´

After adding the above lines in the specific project's sbt file, override the individual settings as necessary.

## scala-formatter common sbt plugin

Check [here](https://github.com/open-electrons/open-electrons-templates/tree/master/open-electrons-scala-formatter-sbt-plugin)

## sbt-scala-project single module

Check [here](https://github.com/open-electrons/open-electrons-templates/tree/master/open-electrons-sbt-template.g8)

## sbt-scala-project multi module

Check [here](https://github.com/open-electrons/open-electrons-templates/tree/master/open-electrons-sbt-template-multi-module.g8)

## License

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">
Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License
</a>
