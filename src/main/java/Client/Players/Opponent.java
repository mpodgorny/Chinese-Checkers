package Client.Players;

import Client.Board.Piece;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static Server.ServerMain.board;

public class Opponent {

    private Piece[] pieces = new Piece[10];


    public Opponent(Color color, String type, GridPane grid){
        fillHome(type,grid,color);

    }

    private void fillHome(String type, GridPane grid, Color color){
                int count=0;
                for(int i=0; i<board.getHeight(); i++){
                    for(int j=0; j<board.getWidth(); j++){
                        if(board.getBoard()[j][i].getTypeOfTile().equals(type)) {
                            GridPane.setConstraints(this.pieces[count] = new Piece(color,j,i), j, i);
                            grid.getChildren().add(this.pieces[count]);
                            count++;
                        }
                    }
                }
    }

}
