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
        fillHome();
        drawPieces(this.grid);
    }

    public void fillHome(){
        int count=0;
        for(int i=0; i<board.getHeight(); i++){
            for(int j=0; j<board.getWidth(); j++){
                if(board.getBoard()[j][i].getTypeOfTile().equals(type)) {
                    this.pieces[count] = new Piece(goalHouse, color,j,i);
                    count++;
                }
            }
        }
    }

    public void drawPieces(GridPane grid){
        int count=0;
        for(int i=0; i<board.getHeight(); i++){
            for(int j=0; j<board.getWidth(); j++){
                if(board.getBoard()[j][i].hasPieceOfColor(color)) {
                    GridPane.setConstraints(this.pieces[count] = board.getBoard()[j][i].getPiece(), j, i);
                    System.out.println("to ile razy się wypierdolę tym razem? (" + color + " --- " + j + " : " + i + ")");
                    try {
                        grid.getChildren().add(this.pieces[count]);
                    }catch(IllegalArgumentException iax){
                    }
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