package in.praj.debugg.screens;

import in.praj.debugg.Known;

import javax.microedition.lcdui.*;

public abstract class EnvValueScreen extends Form {
    private EnvValueScreen(String s) {
        this(s, new Item[]{ new StringItem("Value:", Known.INIT_STRING) });
    }

    private final StringItem valueItem;
    private EnvValueScreen(String s, Item[] items) {
        super(s, items);
        valueItem = (StringItem) items[0];
        addCommand(Known.BACK_CMD);
        setCommandListener(new CommandListener() {
            public void commandAction(Command command, Displayable displayable) {
                whenBacking();
            }
        });
    }

    public EnvValueScreen() {
        this(Known.APP_NAME);
    }

    public void scanEnv(String envName) {
        try {
            valueItem.setText(Known.INIT_STRING);
            final String v = System.getProperty(envName);
            valueItem.setText(v == null ? Known.NULL_STRING : v);
        } catch (Exception e) {
            valueItem.setText("(error: " + e.getMessage() + ")");
        }
    }

    public abstract void whenBacking();
}
