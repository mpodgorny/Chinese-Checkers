package Client.Board;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import static Client.Board.BoardDraw.TILE_RADIUS;

public class Tile extends Circle {

    private Piece piece;

    private String typeOfTile;

    public String getTypeOfTile() {
        return typeOfTile;
    }

    public void setTypeOfTile(String typeOfTile) {
        this.typeOfTile = typeOfTile;
    }

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
        setStroke(Color.DARKGRAY);
        setStrokeWidth(TILE_RADIUS * 0.06);
    }
    public Tile(double x, double y, Color color) {
        //setCenterX(x);
        //setCenterY(y);
        setRadius(TILE_RADIUS);
        setFill(color);
        isSmooth();
        setStroke(Color.DARKGRAY);
        setStrokeWidth(TILE_RADIUS * 0.06);
    }
}
