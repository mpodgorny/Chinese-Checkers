package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerComunication {
    private static int PORT = 2308;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;



    public void connectToServer () throws IOException {

            // Make connection and initialize streams
            try {
                Socket socket = new Socket("localhost", PORT);
                out = new PrintWriter(socket.getOutputStream(), true);
                    System.out.println(in.readLine());
                } catch (Exception ex) {}
    }
}