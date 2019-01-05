package Client.Players;

import Client.Board.Piece;
import Client.Board.StarBoard;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Player {

    private Piece[] pieces = new Piece[10];
    public String goalHouse;
    Color color;
    private boolean ifWon = false;
    private StarBoard board;
    String type;
    GridPane grid;

    public Player(Color color, String type, GridPane grid, String goalHouse, StarBoard board){
        this.goalHouse = goalHouse;
        this.color = color;
        this.type = type;
        this.grid = grid;
        this.board = board;
    }

    public void fillHome(){
        int count=0;
        for(int i=0; i<board.getHeight(); i++){
            for(int j=0; j<board.getWidth(); j++){
                if(board.getBoard()[j][i].getTypeOfTile().equals(type)) {
                    GridPane.setConstraints(this.pieces[count] = new Piece(goalHouse, color,j,i), j, i);
                    grid.getChildren().add(this.pieces[count]);
                    count++;
                }
            }
        }
    }

    public boolean isIfWon() {
        return ifWon;
    }

    public void setIfWon(boolean ifWon) {
        this.ifWon = ifWon;
    }

    public StarBoard getBoard() {
        return board;
    }

    public void setBoard(StarBoard board) {
        this.board = board;
    }
}