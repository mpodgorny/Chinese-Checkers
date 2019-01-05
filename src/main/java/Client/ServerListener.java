package Client;

import Client.Board.FillBoard;
import Client.Board.StarBoard;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

import static javafx.scene.paint.Color.*;
import static javafx.scene.paint.Color.CHOCOLATE;


/**
 * This will control all actions from server, should contain board and pieces etc.
 *
 */
public class ServerListener extends Thread {

    private Menu menu;
    private static DataOutputStream output;
    private static DataInputStream input;
    private boolean Disconnected;
    private boolean isHosting = false;
    private static final Color[] colors = new Color[]{BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    private static volatile int sizeOfLobby;
    private String tempString;
    private static volatile int colorIndex;
    private StarBoard board;

    public ServerListener(Menu menu) {
        this.menu = menu;
        this.output = menu.getOutStream();
        this.input = menu.getInStream();
    }

    @Override
    public void run() {
        String message = "";
        while (true) {
            try {
                message = input.readUTF();
            } catch (IOException ex) {
            }


            switch (message.replace("1", "")
                    .replace("2", "")
                    .replace("3", "")
                    .replace("4", "")
                    .replace("5", "")
                    .replace("6", "")) {
                case "UNABLE":
                    break;
                case "HOST_FOR_TWO":
                    sizeOfLobby = 2;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage);
                    });
                    break;

                case "HOST_FOR_THREE":
                    sizeOfLobby = 3;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage);
                    });
                    break;

                case "HOST_FOR_FOUR":
                    sizeOfLobby = 4;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage);
                    });
                    break;

                case "HOST_FOR_SIX":
                    sizeOfLobby = 6;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage);
                    });
                    break;

                case "CONNECT":
                    tempString = String.format("%c", message.charAt(7));
                    colorIndex = Integer.parseInt(tempString);
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage);
                    });

                    break;

                case "START_GAME":
                    tempString = String.format("%c", message.charAt(10));
                    sizeOfLobby = Integer.parseInt(tempString);
                    board = new StarBoard(37);
                    Platform.runLater(() -> {
                        FillBoard fillBoard = new FillBoard(sizeOfLobby, menu.primaryStage, colors[colorIndex - 1], board);
                    });
                    gameControl();
                    break;

                default:
                    break;

            }
        }

    }

    private static void gameControl() {
        int curColorPlaying = 0;
        while (true) {
            try {
                System.out.println("Pytam o nr koloru");
                curColorPlaying = input.readInt();
                System.out.println("dostalem kolor nr: " + curColorPlaying);
                if (curColorPlaying == colorIndex){
                System.out.println("to ja gram teraz)");
                    output.writeBoolean(true);

                    System.out.println("Gram ja. Wykonuje ruch.... (czekam 4s)");
                    try{sleep(4000);}catch(InterruptedException ex){}
                } else {
                    output.writeBoolean(false);

                    System.out.println("Gra ktoś inny... (czekam 4s)");
                    try {
                        sleep(4000);
                    } catch (InterruptedException ex) {
                    }
                }


            } catch (IOException ex) {}

        }
    }
}
