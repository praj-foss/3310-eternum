package in.praj.dadgpt;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

public class Commands implements CommandListener {
    final Command sendCmd = new Command("Send", Command.OK, 1);
    final Command exitCmd = new Command("Exit", Command.EXIT, 1);

    public void commandAction(Command command, Displayable displayable) {
        if (command == exitCmd) {
            onExit();
        } else if (command == sendCmd) {
            onSend();
        }
    }

    public void onExit() {}

    public void onSend() {}
}
