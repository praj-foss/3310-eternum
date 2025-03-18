package in.praj.mortar;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

public class MainApp extends MIDlet {
    private Display display;
    private Canvas canvas;

    static class MyGameCanvas extends Canvas {
        public void paint(Graphics g) {
            // clear
            g.setColor(0);
            g.fillRect(0, 0, getWidth(), getHeight());

            drawNoise(g);
        }

        public void drawNoise(Graphics g) {
            double F = 1d/30;
            double N = 0.6;
            g.setColor(0xff0000);
            for (int x = 0; x < getWidth(); x++) {
                for (int y = 0; y < getHeight(); y++) {
                    double noise = OpenSimplex2S.noise2_ImproveX(0, x * F, y * F);
                    if (noise > N) {
                        g.drawLine(x, y, x, y);
                    }
                }
            }
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
