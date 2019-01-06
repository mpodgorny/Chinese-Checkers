package Client;

import Client.Board.*;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

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
    private static StarBoard board;

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
                    board = new StarBoard(121);
                    Platform.runLater(() -> {
                        FillBoard fillBoard = new FillBoard(sizeOfLobby, menu.primaryStage, colors[colorIndex - 1], board);
                    });
                    //gameControl();
                    waitForMove();
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

    private void waitForMove(){
        boolean runTUDUDUDU = true;
        while(runTUDUDUDU){
            if(MoveControl.isMoveDone())
                runTUDUDUDU = false;
            else {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Może byś coś zrobił tępy chuju");
        board = makeMove(MoveControl.getMove());
        Platform.runLater(() -> {
            JustDraw justDraw = new JustDraw(board, menu.primaryStage);
        });
        System.out.println("ty w ogóle masz jakąś pasję?");
    }

    private StarBoard makeMove(String move){
        StarBoard starBoard = board;
        String[] components = move.split("-");
        String[] startCords = components[1].split(":");
        String[] endCords = components[2].split(":");
        int startColumn = Integer.parseInt(startCords[0]);
        int startRow = Integer.parseInt(startCords[1]);
        int endColumn = Integer.parseInt(endCords[0]);
        int endRow = Integer.parseInt(endCords[1]);

        Piece tempPiece = starBoard.getBoard()[startColumn][startRow].getPiece();
        starBoard.getBoard()[endColumn][endRow].setPiece(new Piece(tempPiece.getGoalHouse(),tempPiece.getColor(), endColumn, endRow));
        starBoard.getBoard()[startColumn][startRow].dropPiece();

        return starBoard;
    }

    public static StarBoard getBoard() {
        return board;
    }
}
