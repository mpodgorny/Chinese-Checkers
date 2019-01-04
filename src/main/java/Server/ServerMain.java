package Server;


import Client.Board.StarBoard;
import Client.ServerListener;

import javax.sound.sampled.Port;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class ServerMain  {
    static ServerMain server;
    /**
     * @param nicknames holds all names of players.
     */
    static ArrayList<String> nicknames = new ArrayList<String>();
    static List<Socket> sockets = new ArrayList<Socket>();
    static List<DataInputStream> in_list = new ArrayList<DataInputStream>();
    static List<DataOutputStream> out_list = new ArrayList<DataOutputStream>();
    static List<Thread> thread_list = new ArrayList<Thread>();
    public static StarBoard board = new StarBoard(121);
    static Vector<ClientHandler> ar = new Vector<>();
    public static Lobby lobby;
    public static Boolean gameStarted = FALSE;

    ServerSocket ss;

    /**
     * Temporary variable for holding new nickname.
     */
    static String nickname = "";

    /**
     * Signals if some player started the game
     */
    static Boolean game_on = FALSE;



    public static void main(String[] args) throws IOException{
        server = new ServerMain();
        while (true)
        {
            Socket s = null;
            clearSockets();
            try
            {
                // socket object to receive incoming client requests
                s = server.ss.accept();

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

    public ServerMain() {
        try {
            ServerSocket ss = new ServerSocket(2308);
            this.ss = ss;
        } catch(IOException ex) {}
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

    private static ClientHandler setupClientThread(Socket socket) throws IOException{
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
        ClientHandler clientHandler = new ClientHandler(socket, in, out, nickname, server);
        ar.add(clientHandler);
        return clientHandler;
    }

    public static void startGame(){
        gameStarted = true;
        System.out.println("Game started yay");
    }
}
