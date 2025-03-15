package in.praj.debugg;

import in.praj.debugg.screens.EnvNameScreen;
import in.praj.debugg.screens.EnvValueScreen;
import in.praj.debugg.screens.StartScreen;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class MainApp extends MIDlet {
    private Display display;
    private StartScreen startScreen;
    private EnvNameScreen envNameScreen;

    protected void startApp() {
        display = Display.getDisplay(this);

        final EnvValueScreen envValueScreen = new EnvValueScreen() {
            public void whenBacking() {
                display.setCurrent(envNameScreen);
            }
        };

        envNameScreen = new EnvNameScreen() {
            public void whenBacking() {
                display.setCurrent(startScreen);
            }

            public void whenScanningEnv(String envName) {
                display.setCurrent(envValueScreen);
                envValueScreen.scanEnv(envName);
            }
        };

        startScreen = new StartScreen() {
            public void whenExiting() {
                destroyApp(false);
                notifyDestroyed();
            }

            public void whenStartingScan() {
                display.setCurrent(envNameScreen);
            }
        };

        display.setCurrent(startScreen);
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) {

    }
}
