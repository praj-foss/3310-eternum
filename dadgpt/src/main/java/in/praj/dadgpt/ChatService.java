package in.praj.dadgpt;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChatService implements Runnable {
    private SocketConnection socket;
    private InputStream input;
    private OutputStream output;

    public void run() {
        try {
            socket = (SocketConnection) Connector.open("socket://tcpbin.com:4242");
            input = socket.openInputStream();
            output = socket.openOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            // must not happen
        }
    }

    public String exchange(String message) {
        try {
            StringBuffer buffer = new StringBuffer();
            output.write((message + "\r\n").getBytes());

            long start = System.currentTimeMillis();
            System.out.println("SENDING: " + message);
            int r = 0;
            while ((r = input.read()) != -1) {
                System.out.println("CALL: " + ((char) r));
                buffer.append((char) r);
            }
            String res = buffer.toString();
            long end = System.currentTimeMillis();

            System.out.println("RECEIVED: " + res);
            return res + " [TOOK " + (end - start) + "ms]";
        } catch (IOException e) {
            return "ERROR= "+e.getMessage();
        }
    }
}
