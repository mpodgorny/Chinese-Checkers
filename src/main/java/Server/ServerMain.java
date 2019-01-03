package Server;


import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class ServerMain  {


    /**
     * @param nicknames holds all names of players.
     */
    static List<String> nicknames = new ArrayList<String>();
    static List<Socket> sockets = new ArrayList<Socket>();
    static List<DataInputStream> in_list = new ArrayList<DataInputStream>();
    static List<DataOutputStream> out_list = new ArrayList<DataOutputStream>();


    /**
     * Temporary variable for holding new nickname.
     */
    static String nickname = "";

    /**
     * Signals if some player started the game
     */
    static Boolean game_on = FALSE;



    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(2308);
        while (true)
        {
            Socket s = null;


            clearSockets();

            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();

                Thread t = setupClientThread(s);

                // Invoking the start() method
                t.start();

            }catch(NullPointerException nex){
                System.out.println("Nickname is already taken!");
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }

    /**
     * Drop closed sockets
     */
    private static void clearSockets(){
        for(int i = 0; i < sockets.size(); i++) {
            if( sockets.get(i).isClosed() == TRUE) {
                sockets.remove(i);
                if(i>0){i--;}
            }
        }
    }

    private static Thread setupClientThread(Socket socket) throws IOException{
        System.out.println("A new player connected on adress : " + socket);

        // obtaining input and out streams
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        sockets.add(socket); //lista socketow do osblugi odłaczenia użytkownia, ustalania hosta itp - do implementacji.
        in_list.add(in);
        out_list.add(out);


        //Pobiera nickname gracza
        nickname=in.readUTF();
        //jesli nickname zawiera sie w liście nickname'ow wysyla false
        if(nicknames.contains(nickname)) {
            out.writeBoolean(FALSE);
            socket.close();
            in.close();
            out.close();
            sockets.remove(socket);
            System.out.println("Connection with "+socket+" closed.");
            return null;
        }

        out.writeBoolean(TRUE);
        nicknames.add(nickname);
        System.out.println("added nickname |" + nickname +"|\n" +
                "Total player count: " + sockets.size());

        return new ClientHandler(socket, in, out, nickname);
    }

}
