plugins {
    java
}

group = "in.praj.eternum"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.microemu:midpapi20:2.0.4")
    // it's LGPL licensed
}

java {
    targetCompatibility = JavaVersion.VERSION_1_3
    sourceCompatibility = JavaVersion.VERSION_1_3
    // best possible support for MIDP-2.0
}

tasks.jar {
    manifest {
        attributes["MIDlet-1"] = "DEBUGG, , in.praj.debugg.MainApp"
        // app name, app icon and entry point, respectively

        attributes["MIDlet-Name"] = "DEBUGG"
        attributes["MIDlet-Version"] = "1.0.0"
        attributes["MIDlet-Vendor"] = "praj-foss"
        // more app details

        attributes["MicroEdition-Profile"] = "MIDP-2.0"
        attributes["MicroEdition-Configuration"] = "CLDC-1.1"
        // for Nokia 3310 (2017)

        attributes["MIDlet-Description"] = "Scan device properties"
        attributes["MIDlet-Info-URL"] = "https://github.com/praj-foss/3310-eternum/"
        // mostly optional
    }
}
