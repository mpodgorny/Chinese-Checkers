package Client.Board;

import Server.ServerMain;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FillBoard {
    public GridPane grid;
    public Color color;
    public FillBoard(int numberOfPlayers, Stage primaryStage, Color color, StarBoard board) {
        BoardDraw bd = new BoardDraw(primaryStage, board);
        this.grid=bd.getGrid();
        this.color=color;
        PiecesDraw piecesDraw = new PiecesDraw(numberOfPlayers, bd.getGrid(), color, board);
        piecesDraw.drawPieces();
    }
}