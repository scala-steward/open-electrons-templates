## usage

1. Checkout the open-electrons-templates project

2. Run one of the following command

```
// If you have g8 installed locally
g8 file://open-electrons-sbt-template.g8 --o /home/$USER/your/target/location/your-project-name

// Preferred way to create the project
sbt new file://open-electrons-sbt-template.g8 -o /home/$USER/your/target/location/your-project-name

// This option currently does not work
// see https://stackoverflow.com/questions/74969751/create-g8-template-from-a-git-remote-project
sbt new joesan@open-electrons/open-electrons-templates -d open-electrons-sbt-template.g8 -o /home/$USER/your/target/location/your-project-name
```
