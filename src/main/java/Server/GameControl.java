package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static Server.ServerMain.ar;

/**
 * There is only one instance of this thread running -
 * initializied by game host. Sends current colorID that should
 * make a move
 */

public class GameControl extends Thread {

    ServerMain server;
    int nrOfPlayers;

    public GameControl(ServerMain server, int nrOfPlayers) {
        this.server = server;
        this.nrOfPlayers = nrOfPlayers;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < nrOfPlayers; i++) {
                System.out.println("i rowna sie: " + i);
                for (int j = 0; j < ServerMain.ar.size(); j++) {
                    DataInputStream curIn = ar.get(j).in;
                    DataOutputStream curOut = ar.get(j).out;
                    Boolean toBedzieJakisRuch;
                    String tempNick = ar.get(j).nick;
                    System.out.println("Teraz rozdaje " + i + " graczowi " + tempNick);
                    curOut.writeInt(i);
                    System.out.println("czekam na " + tempNick);
                    getCurrentPlayer();
                    System.out.println(tempNick + " wykonal ruchanie");
                }
                if (i == nrOfPlayers - 1) {
                    i = -1;
                }
            }
        } catch (IOException e) {
        }
    }

    public void getCurrentPlayer() {
        for (int j = 0; j < ServerMain.ar.size(); j++) {
            try {
                DataInputStream curIn = ar.get(j).in;
                DataOutputStream curOut = ar.get(j).out;

                if (curIn.readBoolean()) {
                    System.out.println("ten gra");
                } else {
                    System.out.println("A ten nie");
                }

            } catch (IOException e) {
            }
        }


    }
}



