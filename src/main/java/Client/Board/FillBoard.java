package Client.Board;

import Server.ServerMain;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FillBoard {


    public FillBoard(int numberOfPlayers, Stage primaryStage, Color color) {
            BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);
            PiecesDraw piecesDraw = new PiecesDraw(numberOfPlayers, bd.getGrid(), color);
    }
}
