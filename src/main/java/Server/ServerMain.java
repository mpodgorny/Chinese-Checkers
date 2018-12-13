package Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;


public class ServerMain  {



    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(5056);
        while (true)
        {
            Socket s = null;

            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                dos.writeUTF("NICKNAME?");
                String nick = dis.readUTF();


                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos, nick);

                // Invoking the start() method
                t.start();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }

}
