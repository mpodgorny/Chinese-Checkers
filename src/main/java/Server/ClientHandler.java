package Server;

import Client.ServerListener;
import javafx.scene.paint.Color;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static Server.ServerMain.ar;

import static Server.ServerMain.gameStarted;
import static javafx.scene.paint.Color.*;

public class ClientHandler extends Thread {
    final DataInputStream in;
    final DataOutputStream out;
    final Socket s;
    String nick;
    static Boolean isHost = false;
    ServerMain serverMain;
    private static final Color[] colors = new Color[] {BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    public int numberOfPlayers;
    public static int connected=1;

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
        int colorGiver=1;
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
                        giveNumberOfPlayers(2);
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
                        giveNumberOfPlayers(3);
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
                        giveNumberOfPlayers(4);
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
                        giveNumberOfPlayers(6);
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
                if (askIfHosts()) {
                    System.out.println("Dołączono do gry");
                    try {
                        out.writeUTF("CONNECT");
                        connected+=1;
                        incrementNrOfConnectedPlayers(connected);
                        try{out.writeInt(colorGiver);
                            out.writeInt(connected);
                        } catch(IOException x) {}
                        colorGiver++;
                        out.writeInt(numberOfPlayers);
                        if(numberOfPlayers==connected) {
                            out.writeBoolean(true);
                            for (ClientHandler ch: ServerMain.ar) {
                                    ch.out.writeUTF("GAME_READY");
                                    ch.out.writeInt(numberOfPlayers);

                            }
                        } else {
                            out.writeBoolean(false);

                        }


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
    private void giveNumberOfPlayers(int nr) {
        this.numberOfPlayers=nr;
        for (ClientHandler ch: ServerMain.ar) {
        ch.numberOfPlayers=nr;
        }
    }
    private void incrementNrOfConnectedPlayers(int connected) {
        for(ClientHandler ch: ServerMain.ar) {
            ch.connected=connected;
        }
    }
}