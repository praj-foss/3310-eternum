package in.praj.debugg.screens;

import in.praj.debugg.Known;

import javax.microedition.lcdui.*;

public abstract class EnvNameScreen extends List {
    private EnvNameScreen(String s, int i, final String[] strings, Image[] images) {
        super(s, i, strings, images);
        addCommand(Known.BACK_CMD);
        addCommand(Known.SCAN_CMD);
        setSelectCommand(Known.SCAN_CMD);
        setCommandListener(new CommandListener() {
            public void commandAction(Command command, Displayable displayable) {
                if (command == Known.BACK_CMD) {
                    whenBacking();
                    return;
                }
                whenScanningEnv(strings[getSelectedIndex()]);
            }
        });
    }

    private EnvNameScreen(String s, int i) {
        this(s, i, Known.PROPERTIES, null);
    }

    public EnvNameScreen() {
        this(Known.APP_NAME, List.IMPLICIT);
    }

    public abstract void whenBacking();
    public abstract void whenScanningEnv(String envName);
}
