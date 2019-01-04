package Client;

import Client.Board.FillBoard;
import Client.Board.BoardDraw;
import Server.ServerMain;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
            } catch (IOException ex) {}


            switch (message) {

                case "UNABLE":
                    break;
                case "HOST_FOR_TWO":
                    LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, ServerMain.lobby);
                    color = colors[0];

                    break;

                case "HOST_FOR_THREE":

                    break;

                case "HOST_FOR_FOUR":
                    color = colors[0];

                    break;

                case "HOST_FOR_SIX":
                    color = colors[0];

                    break;

                case "CONNECT":
                    try {
                        color = colors[input.readInt()];
                        this.nrOfPlayers = input.readInt();
                        FillBoard fb = new FillBoard(nrOfPlayers, primaryStage, color);
                    }catch(IOException ex) {}

                    break;

                default:
                    break;

            }
        }

    }

}
