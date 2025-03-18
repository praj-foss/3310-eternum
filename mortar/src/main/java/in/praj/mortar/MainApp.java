package in.praj.mortar;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;

public class MainApp extends MIDlet {
    private Display display;
    private MyGameCanvas canvas;

    static class MyGameCanvas extends GameCanvas implements Runnable {
        private double z = 0;
        private double zSpeed = 0.25;
        private long prevTime;
        private Runnable onExit;

        protected MyGameCanvas(boolean b) {
            super(b);
            prevTime = System.currentTimeMillis();
        }

        public void setOnExit(Runnable onExit) {
            this.onExit = onExit;
        }

        public void run() {
            while (true) {
                long now = System.currentTimeMillis();
                double dt = (now - prevTime)/1000d;
                prevTime = now;

                int ks = getKeyStates();
                if ((ks & DOWN_PRESSED) != 0) {
                    break;
                }
                if ((ks & RIGHT_PRESSED) != 0) {
                    z += zSpeed * dt;
                }
                if ((ks & LEFT_PRESSED) != 0) {
                    z -= zSpeed * dt;
                }

                drawNoise(getGraphics());
                flushGraphics();

                System.out.println("OK " + dt);
            }
            if (onExit != null) onExit.run();
        }

        public void drawNoise(Graphics g) {
            g.setColor(0xff0000);
            g.fillRect(0, 0, getWidth(), getHeight());

            double F = 1d/10;
            double N = 0;
            g.setColor(0);
            for (int x = 0; x < getWidth(); x++) {
                for (int y = 0; y < getHeight(); y++) {
                    double noise = OpenSimplex2S.noise3_ImproveXY(0, x * F, y * F, z);
                    if (noise > N) {
                        g.drawLine(x, y, x+1, y+1);
                    }
                }
            }
        }
    }

    protected void startApp() {
        try {
            display = Display.getDisplay(this);
            canvas = new MyGameCanvas(false);
            canvas.setOnExit(new Runnable() {
                public void run() {
                    destroyApp(true);
                    notifyDestroyed();
                }
            });

            display.setCurrent(canvas);
            canvas.setFullScreenMode(true);
            new Thread(canvas).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void pauseApp() {

    }

    protected void destroyApp(boolean b) {
    }
}
