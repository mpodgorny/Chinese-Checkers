package Client;

import Client.Board.*;
import Server.ServerMain;
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
    private static int boardSize;

    public ServerListener(Menu menu) {
        this.menu = menu;
        this.output = menu.getOutStream();
        this.input = menu.getInStream();
        System.out.println("moj nick to: "+menu.nickname);
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
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, "Waiting for other players...");
                    });
                    break;

                case "HOST_FOR_THREE":
                    sizeOfLobby = 3;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, "Waiting for other players...");
                    });
                    break;

                case "HOST_FOR_FOUR":
                    sizeOfLobby = 4;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, "Waiting for other players...");
                    });
                    break;

                case "HOST_FOR_SIX":
                    sizeOfLobby = 6;
                    colorIndex = 1;
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, "Waiting for other players...");
                    });
                    break;

                case "CONNECT":
                    tempString = String.format("%c", message.charAt(7));
                    colorIndex = Integer.parseInt(tempString);
                    Platform.runLater(() -> {
                        LobbyDraw lobbyDraw = new LobbyDraw(menu.primaryStage, "Waiting for other players...");
                    });

                    break;

                case "START_GAME":
                    tempString = String.format("%c", message.charAt(10));
                    sizeOfLobby = Integer.parseInt(tempString);
                    boardSize = 121;
                    board = new StarBoard(boardSize);
                    Platform.runLater(() -> {
                        //FillBoard fillBoard = new FillBoard(sizeOfLobby, menu.primaryStage, colors[colorIndex - 1], board);

                        PiecesDraw piecesDraw = new PiecesDraw(sizeOfLobby, board);
                        JustDraw justDraw = new JustDraw(board, menu.primaryStage);
                    });
                    try {
                        startedGameService();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //gameControl();
                    //waitForMove();
                    break;

                default:
                    break;

            }
        }

    }

    private void waitForMove(){
        boolean runTUDUDUDU = true;
        while(runTUDUDUDU){
            if(MoveControl.isMoveDone())
                if(MoveControl.getMove().split("-")[0].equals(colors[colorIndex-1].toString())) {
                    runTUDUDUDU = false;
                } else {
                    System.out.println("Wrong color");
                    MoveControl.setMoveDone(false);
                }
            else {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static StarBoard getBoard() {
        return board;
    }

    public void startedGameService() throws IOException {
        output.writeInt(boardSize);
        boolean gameWon = false;
        while(true){
            if(gameWon && wonByColor(board, colors[colorIndex-1])){
                //System.out.println("you won!");
                gameWon = true;
                String message = input.readUTF();
                if (message.equals("YOUR_TURN")) {
                    output.writeUTF("SKIP_TURN");
                }
            }else {
                String message = input.readUTF();
                if (message.equals("YOUR_TURN")) {
                    boolean moveCorrect = false;
                    while (!moveCorrect) {
                        MoveControl.setMoveDone(false);
                        MoveControl.setMove(null);
                        waitForMove();
                        String move = MoveControl.getMove();
                        output.writeUTF(move);
                        if (input.readInt() > 0)
                            moveCorrect = true;
                    }
                } else if (!message.equals("SKIP_TURN")) {
                    ServerMain.makeMove(message, board);
                    Platform.runLater(() -> {
                        JustDraw justDraw = new JustDraw(board, menu.primaryStage);
                    });
                }
            }
        }
    }

    public boolean wonByColor(StarBoard board, Color color){
        System.out.println("C'mon do sth");
        for(int i=0; i<board.getHeight(); i++){
            for(int j=0; j<board.getWidth(); j++){
                if(board.getBoard()[j][i].hasPiece()
                        /*&& board.getBoard()[j][i].getPiece().getColor()==color*/){
                    System.out.println("dobry klocek mordo");
                    if(board.getBoard()[j][i].getTypeOfTile()!=board.getBoard()[j][i].getPiece().getGoalHouse())
                        return false;
                }
            }
        }
        return true;
    }
}
