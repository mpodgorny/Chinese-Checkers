package Server;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    Socket socket;

    public Client(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream in = null;
        BufferedReader out = null;
        DataOutputStream dataOut = null;

        try {
            in = socket.getInputStream();
            out = new BufferedReader(new InputStreamReader(in));
            dataOut = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = out.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                } else {
                    dataOut.writeBytes(line + "\n\r");
                    dataOut.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }


}
