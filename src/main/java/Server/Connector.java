package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector {

    public ServerSocket serverSocket;
    public int port = 2308;
    Socket socket;
    public Connector() {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new Client(socket).start();
        }


    }
}
