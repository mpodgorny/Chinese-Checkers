package Client;

import Client.Board.FillBoard;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

import static javafx.scene.paint.Color.*;


/**
 * This will control all actions from server, should contain board and pieces etc.
 *
 */
public class ServerListener extends Thread {

    private Stage primaryStage;
    private Menu menu;
    private DataOutputStream output;
    private DataInputStream input;
    private boolean Disconnected;
    private boolean isHosting=false;
    private static final Color[] colors = new Color[] {BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    private Color color;
    private int nrOfPlayers;
    private int connected=0;
    private boolean inLobby = false;

    public ServerListener(Menu menu) {
        this.menu= menu;
        output = menu.getOutStream();
        input = menu.getInStream();
        this.primaryStage=menu.primaryStage;
    }
        @Override
        public void run() {
            String message = "";
            while (true) {
                try {
                    message = input.readUTF();
                } catch (IOException ex) {
                }

                switch (message) {

                    case "UNABLE":
                        break;
                    case "HOST_FOR_TWO":
                        color = colors[0];

                        break;

                    case "HOST_FOR_THREE":
                        color = colors[0];
                        break;

                    case "HOST_FOR_FOUR":
                        color = colors[0];

                        break;

                    case "HOST_FOR_SIX":
                        color = colors[0];

                        break;

                    case "CONNECT":
                        try {
                            inLobby =true;
                            color = colors[input.readInt()];
                            connected = input.readInt();
                            this.nrOfPlayers = input.readInt();
                            System.out.println("Color: " + color + "nrOfPlayers: " + nrOfPlayers + " Connected: " + connected);
                            boolean ifReady = input.readBoolean();
                            if (ifReady) {
                                System.out.println("READI");
                                Platform.runLater(() -> {
                                    FillBoard fb = new FillBoard(nrOfPlayers, primaryStage, color);
                                    GameServerListener gm = new GameServerListener(input,output,fb,nrOfPlayers);

                                });
                                } else {
                                System.out.println("NOT READI");
                            }

                        } catch (IOException ex) {
                        }

                        break;
                    case "GAME_READY":
                        try{nrOfPlayers=input.readInt();}catch(IOException ex) {}
                            Platform.runLater(() -> {
                                FillBoard fb = new FillBoard(nrOfPlayers, primaryStage, color);
                               GameServerListener gm = new GameServerListener(input,output,fb,nrOfPlayers);
                            });

                    default:
                        break;

                }
            }

        }

    void waitForPlayers(){

    }
}
