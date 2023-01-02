# Project Title

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links

*** For information on how to create shields and icons, have a look at this useful documentation
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
    <li><a href="#releases">Releases</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#builtwith">Built With</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

Some informational content on what this project is about!

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

What needs to be done so that the user of this project can get started with using it or trying it!

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Prerequisites

Anything that needs to be pre-installed should be documented here

### Publishing

How to publish this project (if needed) so that it can be run / tried out

<!-- USAGE EXAMPLES -->
## Usage

If this project is meant to be used by other projects, provide information on how to use it

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- RELEASES -->
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

For releases, [see the releases page here](https://github.com/open-electrons/open-electrons-templates/releases)

TODO: Change the project name filter {{repo_name=open-electrons-project-name}}
For published packages, [see the packages page here](https://github.com/orgs/open-electrons/packages?repo_name=open-electrons-project-name)

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

Distributed under the Apache License 2.0. See `LICENSE.md` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Joesan on Mastodon - [@joesan@fosstodon.org](https://fosstodon.org/@joesan)

Project Link: [https://github.com/open-electrons](https://github.com/open-electrons)

Project Documentation: [https://open-electrons.github.io/home/](https://open-electrons.github.io/home/)

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
