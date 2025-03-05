package in.praj.eternum;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import java.io.IOException;

public class MainApp extends MIDlet {
    private Display display;
    private Canvas canvas;

    static class MyGameCanvas extends Canvas {
        private final Image bg;

        MyGameCanvas() throws IOException {
            bg = Image.createImage("/background.png");
        }

        public void paint(Graphics g) {
            // clear
            g.setColor(0xff0000);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(0);
            int S = 40;
            g.fillRect(S, S, getWidth()- S, g.getClipHeight() - S);

            g.drawImage(bg, 0, 0, Graphics.TOP | Graphics.LEFT);

            g.setColor(255, 255, 0);
            for (int i = 40; i < getHeight()-40; i += 20) {
                g.drawLine(0, getHeight()/2, getWidth()/6, i);
            }

            g.setColor(0, 255, 255);
            String details = "W="+getWidth()+", H="+getHeight();
            g.drawString(details, 0, getHeight() - g.getFont().getHeight(), 0);
        }
    }

    protected void startApp() {
        try {
            display = Display.getDisplay(this);
            canvas = new MyGameCanvas();

            display.setCurrent(canvas);
            canvas.setFullScreenMode(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) {
    }
}
