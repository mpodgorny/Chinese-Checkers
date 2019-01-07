package Server;


import Client.Board.*;
import Client.ServerListener;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javax.sound.sampled.Port;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

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
    static ArrayList<Thread> thread_list = new ArrayList<Thread>();
    static volatile ArrayList<ClientHandler> ar=new ArrayList<ClientHandler>();

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
        int i=0;
        while (true)
        {
            Socket s = null;
            clearSockets();
            try
            {
                // socket object to receive incoming client requests
                s = server.ss.accept();
                if(ClientHandler.gameStarted) {
                    startGame();
                    System.out.println("gra wystartowała");
                }

                Thread t = setupClientThread(s);
                thread_list.add(t);

                // Invoking the start() method
                t.start();

            }catch(NullPointerException nex){
                System.out.println("Nickname is already taken!");
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
            if(ClientHandler.gameStarted == true){
                startGame();
            }
            /*if(thread_list.size()>5){
                while (!ClientHandler.gameStarted){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startGame();
            }*/
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

    public static void startGame() throws IOException {
        boolean ifJumped = false;
        int boardSize=1;
        for(int i=0; i<ar.size(); i++){
            boardSize = ar.get(i).in.readInt();
        }
        StarBoard board = new StarBoard(boardSize);
        PiecesDraw piecesDraw = new PiecesDraw(ar.size(), board);
        String jumpedOver = "FALSE";
        Random random = new Random();
        int i=random.nextInt(ar.size()-1);
        while(true){
            String move="";
            ClientHandler ch = ar.get(i);
            ch.out.writeUTF("YOUR_TURN");
            boolean moveDone = false;
            while(!moveDone){
                move = ch.in.readUTF();
                if(!move.equals("SKIP_TURN")) {
                    int moveCorrect;
                    if (!jumpedOver.equals("FALSE"))
                        move = jumpedOver + move.split("-")[2];
                    moveCorrect = MoveChecks.fullCheck(move, board, ifJumped);
                    ch.out.writeInt(moveCorrect);
                    if (moveCorrect > 0) {
                        moveDone = true;
                        makeMove(move, board);
                        if (moveCorrect == 2) {
                            i--;
                            jumpedOver = move.split("-")[0] + "-" + move.split("-")[2] + "-";
                            ifJumped=true;
                        } else {
                            jumpedOver = "FALSE";
                            ifJumped=false;
                        }
                    }
                }else{
                    ch.out.writeInt(1);
                    moveDone = true;
                    jumpedOver = "FALSE";
                    ifJumped = false;
                }
            }
            for(int j=0; j<ar.size(); j++){
                ar.get(j).out.writeUTF(move);
            }
            if(i==ar.size()-1)
                i=0;
            else
                i++;
        }
    }

    public static void makeMove(String move, StarBoard board){
        String[] components = move.split("-");
        String[] startCords = components[1].split(":");
        String[] endCords = components[2].split(":");
        int startColumn = Integer.parseInt(startCords[0]);
        int startRow = Integer.parseInt(startCords[1]);
        int endColumn = Integer.parseInt(endCords[0]);
        int endRow = Integer.parseInt(endCords[1]);

        Piece tempPiece = board.getBoard()[startColumn][startRow].getPiece();
        board.getBoard()[endColumn][endRow].setPiece(new Piece(tempPiece.getGoalHouse(), tempPiece.getColor(), endColumn, endRow, board));
        board.getBoard()[startColumn][startRow].dropPiece();
    }

    private static void upośledzonaMetodaBoNieMamCzasuRozdzielaćKlas(StarBoard board){

    }
}
