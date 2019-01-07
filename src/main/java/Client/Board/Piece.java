package Client.Board;

import Client.ServerListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Client.Board.StarBoard.TILE_RADIUS;

public class Piece extends StackPane {

    static private final double PIECE_SIZE = TILE_RADIUS*0.75;
    public int column, row;
    private Color color;
    private String goalHouse;
    private String move;
    private boolean moveMade = false;
    private int count = 0;

    /**
     * constructor
     * @param goalHouse
     * @param color
     * @param x
     * @param y
     * @param board
     */
    public Piece(String goalHouse, Color color, int x, int y, StarBoard board) {
        this.goalHouse=goalHouse;
        this.column=x;
        this.row=y;
        this.color=color;
        Circle piece = new Circle();
        piece.setStroke(Color.RED);
        piece.setStrokeWidth(PIECE_SIZE * 0.03);
        piece.setRadius(PIECE_SIZE);
        piece.setFill(color);
        piece.setStroke(Color.DARKGRAY);
        piece.setStrokeWidth(TILE_RADIUS * 0.06);
        piece.isSmooth();

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                MoveControl.setMove(String.format("%s-%d:%d-", color.toString(), column, row));
                MoveControl.setMoveDone(false);
            }
        });
        getChildren().add(piece);
        board.getBoard()[x][y].setPiece(this);
    }
    public int getColumn(){return column;}
    public int getRow(){return row;}
    public Color getColor(){return this.color;}
    public Piece chosenPiece(){return this;}
    public void dropPiece(){
        getChildren().remove(this);
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getGoalHouse() {
        return goalHouse;
    }
}