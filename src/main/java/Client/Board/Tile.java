package Client.Board;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import static Client.Board.StarBoard.TILE_RADIUS;

public class Tile extends Circle {

    public int column;
    public int row;
    private String typeOfTile;
    private Piece piece = null;

    public String getTypeOfTile() {
        return typeOfTile;
    }

    public void setTypeOfTile(String typeOfTile) {
        this.typeOfTile = typeOfTile;
    }

    /**
     * constructor
     * @param column
     * @param row
     */
    public Tile(int column, int row) {
        this.column=column;
        this.row=row;

        setRadius(TILE_RADIUS);
        setFill(Color.SILVER);
        isSmooth();
        setStroke(Color.DARKGRAY);
        setStrokeWidth(TILE_RADIUS * 0.06);

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                MoveControl.setMove(MoveControl.getMove() + String.format("%d:%d", column, row));
                MoveControl.setMoveDone(true);
            }
        });

    }

    /**
     * another constructor, but with chosable color
     * @param column
     * @param row
     * @param color
     */
    public Tile(int column, int row, Color color) {
        this.column=column;
        this.row=row;

        setRadius(TILE_RADIUS);
        setFill(color);
        isSmooth();
        setStroke(Color.DARKGRAY);
        setStrokeWidth(TILE_RADIUS * 0.06);

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                MoveControl.setMove(MoveControl.getMove() + String.format("%d:%d", column, row));
                MoveControl.setMoveDone(true);
            }
        });
    }

    public int getRow(){return row;}
    public int getColumn(){return column;}
    public Tile getTile() {return this;}

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void dropPiece() {
        piece.dropPiece();
        piece = null;
    }

    public boolean hasPieceOfColor(Color color){
        try{
            if(piece.getColor() == color)
                return true;
        }catch(NullPointerException npex){
        }
        return false;
    }

    public boolean hasPiece(){
        if(piece != null)
            return true;
        return false;
    }
}
