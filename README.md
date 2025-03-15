3310 Eternum
===

A place where I can keep experimenting with my 
[Nokia 3310](https://lpcwiki.miraheze.org/wiki/Nokia_3310_(2017)) forever!

### Building

JDK 8 is necessary to compile these. Download and install one for your OS from the
[Temurin](https://adoptium.net/temurin/releases/?version=8&package=jdk) releases.

Once JDK is installed, use the following command to build:

```shell
./gradlew :example:jar
# replace 'example' with the target subproject name 
```

To emulate the jars locally, use [MicroEmulator](https://sourceforge.net/projects/microemulator/)

### DEBUGG

This is an app for scanning java environment of the device. Comes with a known list of property names.
Refer to [releases](https://github.com/praj-foss/3310-eternum/releases) for downloading `debugg.jar`.

![DEBUGG - Environment names](/env/debugg-envs.jpg)

![DEBUGG - Environment value](/env/debugg-value.jpg)

Command to build jar file:

```shell
./gradlew :debugg:jar 
```

File is generated at `debugg/build/libs/debugg.jar`.

#### Thanks!
