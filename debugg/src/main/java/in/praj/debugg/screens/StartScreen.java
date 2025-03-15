package in.praj.debugg.screens;

import in.praj.debugg.Known;

import javax.microedition.lcdui.*;

public abstract class StartScreen extends Form {
    private StartScreen(String s) {
        this(s, new Item[] {
                new StringItem("Usage", "Scan java environment properties on this device")
        });
    }

    private StartScreen(String s, Item[] items) {
        super(s, items);
        addCommand(Known.EXIT_CMD);
        addCommand(Known.SCAN_CMD);
        setCommandListener(new CommandListener() {
            public void commandAction(Command command, Displayable displayable) {
                if (command == Known.EXIT_CMD) {
                    whenExiting();
                    return;
                }
                whenStartingScan();
            }
        });
    }

    public StartScreen() {
        this(Known.APP_NAME);
    }

    public abstract void whenExiting();
    public abstract void whenStartingScan();
}
