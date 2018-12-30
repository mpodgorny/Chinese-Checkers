package Client.Board;

import com.sun.org.apache.xerces.internal.dom.ChildNode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Client.Board.BoardDraw.TILE_RADIUS;
import static Client.Board.BoardDraw.indentation;
import static sun.dc.pr.Rasterizer.TILE_SIZE;

public class Piece extends StackPane {

    static private final double PIECE_SIZE = TILE_RADIUS*0.8;
    private double mouseX, mouseY;
    private double oldX, oldY;

    public Piece(int x, int y) {

        Circle piece = new Circle();
        piece.setStroke(Color.RED);
        piece.setStrokeWidth(PIECE_SIZE * 0.03);
        piece.setRadius(PIECE_SIZE);
        piece.setFill(Color.RED);
        piece.setStroke(Color.DARKGRAY);
        piece.setStrokeWidth(TILE_RADIUS * 0.06);
        piece.isSmooth();

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
        getChildren().add(piece);
    }
    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
}
