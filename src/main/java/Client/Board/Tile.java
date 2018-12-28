package Client.Board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Client.Board.BoardDraw.TILE_RADIUS;

public class Tile extends Circle {

    private Piece piece;

    public boolean hasPiece() {
        return piece != null;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile(double x, double y) {
        //setCenterX(x);
        //setCenterY(y);
        setRadius(TILE_RADIUS);
        setFill(Color.SILVER);
        isSmooth();
    }
}
