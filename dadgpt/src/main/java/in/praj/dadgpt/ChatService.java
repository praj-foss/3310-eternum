package in.praj.dadgpt;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChatService {
    private SocketConnection socket;
    private InputStream input;
    private OutputStream output;

    private long openTime;
    private long exchTime;
    private String msg;

    public void run(String s) {
        try {
            long start = System.currentTimeMillis();
            socket = (SocketConnection) Connector.open("socket://tcpbin.com:4242");
            input = socket.openInputStream();
            output = socket.openOutputStream();
            openTime = System.currentTimeMillis() - start;

            exchange(s);
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

    public String getTime() {
        return "open = " + openTime + "ms, exch = " + exchTime + "ms, msg = " + msg;
    }

    StringBuffer buffer = new StringBuffer();
    public String exchange(String message) {
        try {
            buffer.delete(0, buffer.length());
            output.write((message + "\r\n").getBytes());

            long start = System.currentTimeMillis();
            System.out.println("SENDING: " + message);
            int r = 0;
            while ((r = input.read()) != -1) {
                buffer.append((char) r);
            }
            msg = buffer.toString();
            exchTime = System.currentTimeMillis() - start;

            System.out.println("RECEIVED: " + msg);
            return msg;
        } catch (IOException e) {
            return "ERROR= "+e.getMessage();
        }
    }
}
