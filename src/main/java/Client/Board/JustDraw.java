package Client.Board;

import javafx.stage.Stage;

public class JustDraw {
    public JustDraw(StarBoard board, Stage primaryStage){
        BoardDraw bd = new BoardDraw(primaryStage, board);
        for(int i=0; i<PiecesDraw.getPlayers().size(); i++){
            PiecesDraw.getPlayers().get(i).drawPieces(bd.getGrid());
        }
    }
}
