package Client.Board;

import Server.ServerMain;
import javafx.stage.Stage;

public class FillBoard {

    public FillBoard(int numberOfPlayers, Stage primaryStage) {
        BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);
        PiecesDraw piecesDraw = new PiecesDraw(numberOfPlayers, bd.getGrid());


    }
}
