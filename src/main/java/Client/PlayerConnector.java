package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerConnector {

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    PrintWriter out = null;

    PlayerConnector() throws Exception {
        socket = new Socket("localhost", PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    PrintWriter getWriter () {
        return this.out;
    }

}
