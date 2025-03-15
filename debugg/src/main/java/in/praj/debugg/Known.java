package in.praj.debugg;

import javax.microedition.lcdui.Command;

/**
 * Static access to known constants.
 */
public final class Known {
    public static final String APP_NAME = "DEBUGG";
    public static final String[] PROPERTIES = new String[] {
            "user.name",
            "user.home",
            "user.dir",

            "os.name",
            "os.version",
            "os.arch",

            "java.version",
            "java.fullversion",
            "java.home",
            "java.vendor",
            "java.compiler",
            "java.class.path",

            "microedition.deviceid",
            "microedition.deviceid.uuid",
            "microedition.deviceid.imei",
            "microedition.deviceid.esn",
            "microedition.deviceid.meid",
            "microedition.deviceid.pesn",
            "microedition.deviceid.isunique",
            "microedition.devicevendor",
            "microedition.devicevendor.isunique",
            "microedition.locale",
            "microedition.profiles",
            "microedition.platform",
            "microedition.security.authentication",
            "microedition.security.policy",
            "microedition.commports",
            "microedition.hostname",
            "microedition.lui",
            "microedition.key",
            "microedition.rms",
            "microedition.media.audio",
            "microedition.io",
            "microedition.io.gcf",
            "microedition.swm",
            "microedition.cellular",
            "microedition.event",
            "microedition.power",

            "file.separator",
            "line.separator",
            "path.separator",
    };

    public static final String INIT_STRING = "(reading...)";
    public static final String NULL_STRING = "(unavailable)";

    public static final Command SCAN_CMD = new Command("Scan", Command.OK, 2);
    public static final Command BACK_CMD = new Command("Back", Command.BACK, 1);
    public static final Command EXIT_CMD = new Command("Exit", Command.EXIT, 1);
}
