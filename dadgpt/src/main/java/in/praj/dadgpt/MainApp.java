package in.praj.dadgpt;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class MainApp extends MIDlet {
    private Display display;
    private Form root;
    private Commands cmd;
//    private Thread serviceThread;
    private ChatService service;

    protected void startApp() {
        root = new Form("DadGPT");

        final StringItem answerItem = new StringItem("Answer:", "(type question and send)");
        root.append(answerItem);

        final TextField questionItem = new TextField("Question:", "What is the Moon?", 144, TextField.ANY);
        root.append(questionItem);

        service = new ChatService();

        cmd = new Commands() {
            public void onSend() {
                System.out.println("Entered senddddd");
                answerItem.setText(service.exchange(questionItem.getString()));
            }

            public void onExit() {
                destroyApp(false);
                notifyDestroyed();
            }
        };

        root.addCommand(cmd.exitCmd);
        root.addCommand(cmd.sendCmd);
        root.setCommandListener(cmd);

        display = Display.getDisplay(this);
        display.setCurrent(root);

        service.run("OK__" + getAppProperty("MIDlet-Name"));
        answerItem.setText(service.getTime());


//        serviceThread = new Thread(service);
//        serviceThread.start();
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) {
        service.destroy();
    }
}
