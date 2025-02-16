package in.praj.eternum;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class MainApp extends MIDlet {
    private final Alert alert = new Alert("420");

    protected void startApp() {
        alert.setString("Hello world!");
        Display.getDisplay(this).setCurrent(alert);
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) {

    }
}
