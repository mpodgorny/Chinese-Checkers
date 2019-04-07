package Client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public interface SocketControl {

    InetAddress getAddress();
    Socket getSocket(InetAddress ip);
    DataInputStream getInputStream(Socket s);
    DataOutputStream getOutputStream(Socket s);

}