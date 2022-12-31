# sbt-common-formatter-plugin

This is a sbt plugin that contains the distributable scala source code formatter settings that are supposed to be used
across all the other open-electrons projects.

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links

*** For informarion on how to create shields and icons, have a look at this useful documentation
*** https://javascript.plainenglish.io/how-to-make-custom-language-badges-for-your-profile-using-shields-io-d2aeaf016b6b

TODO: These badges do not apply yet as the repo is still in private mode!

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

-->

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#publishing">Publishing</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#builtwith">Built With</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

Having a formatted source code is essential in any project, having the settings and configuration for the formatter in one
common location that can be shared across projects is even more important so that the changes to the formatter
happens once in a single place and can be controlled, distributed and applied to all the other projects.

Scala [sbt](https://www.scala-sbt.org/) offers a way to [build your own plugin](https://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin) 
and use it in your projects. This is exactly what we do here, the common formatter settings are configured here and is
built and published as a jar which is then used by the referenced projects during the build phase.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

We use [scalafmt](https://scalameta.org/scalafmt/) for formatting all source code, build files etc.,

To add any new scala formatter settings using the [configuration options](https://scalameta.org/scalafmt/docs/configuration.html)
go to the OpenElectronsScalaFmtPlugin.scala file and there you will find the commonly defined configurations defined
as:

```scala
  val commonScalaFormatConfig: String =
    """
      |version = 3.6.1
      |runner.dialect = scala213source3
      ...
      ...
    """
```

defined as a [string interpolaion](https://docs.scala-lang.org/overviews/core/string-interpolation.html). To add any new
configuration or update the existing ones, directly modify it there. Please refer to the <a href="#publishing">Publishing</a>
on how to publish your changes so that all the other projects can apply this new formatter configuration.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Prerequisites

You need to have the following tools installed on your local machine
* scala
  ```
  https://scala-lang.org
  ```

* sbt
  ```
  https://www.scala-sbt.org/
  ```

### Publishing

_This project is intended to be used as a sbt plugin library. To publish the project locally to your repository cache, run 
the following steps_

1. Clone the repo
   ```sh
   git clone https://github.com/open-electrons/open-electrons-templates.git
   ```

2. Navigate to the project folder
   ```sh
   me@my-linux-machine:~/Projects/open-electrons-templates$ cd sbt-common-formatter-plugin/
   ```

3. To build and publish locally on your machine
   ```
   sbt compile publishLocal
   ```

    By default, the project is compiled to Scala 2.12.17. As sbt currently only supports scala 2.12, all plugins that
    are built should be published for Scala 2.12 only.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

To add this plugin to your project, make sure to include the following to your plugins.sbt:

In your _plugins.sbt_ add the plug in definitions:
```
// For formatting source code
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
addSbtPlugin("com.openelectrons" % "openelectrons-scalafmt" % "0.0.1")
```

In your _build.sbt_ enable the plugin:
```
lazy val yourModule =
  module("your-scala-project")
    .enablePlugins(AutomateHeaderPlugin, OpenElectronsScalaFmtPlugin)
    .settings(
      name := """your-scala-project""",
      ......
      ......
    )
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.md` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Joesan on Mastodon - [@joesan@fosstodon.org](https://fosstodon.org/@joesan)

Project Link: [https://github.com/open-electrons/ocpp-example-server](https://github.com/open-electrons/ocpp-example-server)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

* [![Scala][Scala]][Scala-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/open-electrons/ocpp-example-server.svg?style=for-the-badge
[contributors-url]: https://github.com/open-electrons/ocpp-example-server/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/open-electrons/ocpp-example-server.svg?style=for-the-badge
[forks-url]: https://github.com/open-electrons/ocpp-example-server/network/members
[stars-shield]: https://img.shields.io/github/stars/open-electrons/ocpp-example-server.svg?style=for-the-badge
[stars-url]: https://github.com/open-electrons/ocpp-example-server/stargazers
[issues-shield]: https://img.shields.io/github/issues/open-electrons/ocpp-example-server.svg?style=for-the-badge
[issues-url]: https://github.com/open-electrons/ocpp-example-server/issues
[license-shield]: https://img.shields.io/github/license/open-electrons/ocpp-example-server.svg?style=for-the-badge
[license-url]: https://github.com/open-electrons/ocpp-example-server/blob/master/LICENSE.md
[product-screenshot]: images/screenshot.png
[Scala]: https://img.shields.io/badge/-scala-red?logo=scala
[Scala-url]: https://www.scala-lang.org/
[Play-Framework]: https://img.shields.io/badge/-play-green?logo=play-framework
[Play-Framework-url]: https://www.playframework.com/

-------------------- OLD README ----------------------------------------------------------------------------------------


# Open Charge Point Protocol for Scala

To build and publish locally: sbt publishLocal

#### Supported operations

The spec covers the OCPP 2.0.1 JSON specification. All the messages listed as per the specification is implemented.

## Usage

Packages are cross compiled to Scala versions 2.12 and 3.1. So just pick the version that you need.

For sbt, 
```
"org.openelectrons" %% "ocpp-messages" % 0.0.7-SNAPAHOT
"org.openelectrons" %% "ocpp-j-api"    % 0.0.7-SNAPAHOT
```

## Releases

We use tag's for doing releases. To tag a release do the following:

1. Commit pending changes into the master branch and push the master branch into Git

2. Run the following commands (Make sure to adjust the SemVer appropriately):

```
git tag -a v2.2.2 -m "Your comments" // Create annotated tag

git push origin --tags               // Push annotated tag
```

To have automatic bump of the tags, use the following command:

```
// Create annotated tag by incrementing the latest tag version
git tag -a `git describe --tags --abbrev=0 | awk -F. '{OFS="."; $NF+=1; print $0}'`-SNAPSHOT -m "your comments"

 // Push the recently annotated tag
git push origin --tags              
```

For more information on releases, see the releases page [here](https://github.com/open-electrons/ocpp-scala/releases)

For more information on published packages, see the packages page [here](https://github.com/orgs/open-electrons/packages?repo_name=ocpp-scala)

## Licensing

This software is licensed under MIT License. [Have a look here for more information](https://github.com/open-electrons/ocpp-scala/blob/master/LICENSE)

## Contributing

For more information on how to contribute, have a look [here](https://github.com/open-electrons/ocpp-scala/blob/master/CONTRIBUTING.md)

## Maintainers

- [Joesan](https://github.com/joesan)

## Acknowledgements

- [Open Charge Alliance](https://www.openchargealliance.org/)





