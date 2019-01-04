package Server;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static Server.ServerMain.ar;
import static Server.ServerMain.gameStarted;

public class ClientHandler extends Thread {

    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream in;
    final DataOutputStream out;
    final Socket s;
    String nick;
    static Boolean isHost = false;
    int typeOfGame;
    ServerMain serverMain;

    // Constructor
    public ClientHandler(Socket s, DataInputStream in, DataOutputStream out, String nickname, ServerMain serverMain) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.nick = nickname;
        this.serverMain = serverMain;
    }

    @Override
    public void run() {
        while (true){
        String input = "";
        try {
            input = in.readUTF();
            System.out.println("Dostalismy: " + input);
        } catch (Exception ex) {
            System.out.println("coś jest nie tak");
        }

            if (input.equals("GAME_FOR_TWO")) {
                if (!askIfHosts()) {
                    isHost = true;
                    System.out.println("Hostuj gre dla dwoch");
                    try {
                        out.writeUTF("HOST_FOR_TWO");
                    } catch (IOException ex) {
                    }
                } else
                    System.out.println("Cannot host - game room in progress");
                try {
                    out.writeUTF("UNABLE");
                } catch (IOException ex) {
                }


            } else if (input.equals("GAME_FOR_THREE")) {
                //hostuj gre dla 3
                if (!askIfHosts()) {
                    isHost = true;
                    System.out.println("Hostuj gre dla trzech");
                    try {
                        out.writeUTF("HOST_FOR_THREE");
                    } catch (IOException ex) {
                    }
                } else
                    System.out.println("Cannot host - game room in progress");
                try {
                    out.writeUTF("UNABLE");
                } catch (IOException ex) {
                }

            } else if (input.equals("GAME_FOR_FOUR")) {
                if (!askIfHosts()) {
                    isHost = true;
                    System.out.println("Hostuj gre dla czterech");
                    try {
                        out.writeUTF("HOST_FOR_FOUR");
                    } catch (IOException ex) {
                    }
                } else
                    System.out.println("Cannot host - game room in progress");
                try {
                    out.writeUTF("UNABLE");
                } catch (IOException ex) {
                }

            } else if (input.equals("GAME_FOR_SIX")) {
                if (!askIfHosts()) {
                    isHost = true;
                    System.out.println("Hostuj gre dla szesciu");
                    try {
                        out.writeUTF("HOST_FOR_SIX");
                    } catch (IOException ex) {
                    }
                } else
                    System.out.println("Cannot host - game room in progress");
                try {
                    out.writeUTF("UNABLE");
                } catch (IOException ex) {
                }

            } else if (input.equals("CONNECT_TO_GAME")) {
                //dolacz do istniejacej gry
                if (askIfHosts() && !gameStarted) {
                    ServerMain.lobby.addPlayer(nick);
                    System.out.println("Dołączono do gry");
                    try {
                        out.writeUTF("CONNECT");
                    } catch (IOException ex) {
                    }
                } else
                    try {
                        out.writeUTF("UNABLE");
                    } catch (IOException ex) {
                    }

            } else {
                System.out.println("Program shouldn't be here");

            }
        }

    }

    private Boolean askIfHosts() {
        System.out.println("Sprawdzam czy sa hosty.");
        Boolean isHosting=false;
        for (ClientHandler ch: ServerMain.ar) {
        if(ch.isHost){
            isHosting=true;
            break;
        }
        }
        System.out.println("Ktos hostuje: " + isHosting);
        return isHosting;
    }
}