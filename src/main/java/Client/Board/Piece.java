package Client.Board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static Client.Board.StarBoard.TILE_RADIUS;

public class Piece extends StackPane {

    static private final double PIECE_SIZE = TILE_RADIUS*0.75;
    private double mouseX, mouseY;
    private double oldX, oldY;
    public int X, Y;

    public Piece(Color color, int x, int y) {

        Circle piece = new Circle();
        piece.setStroke(Color.RED);
        piece.setStrokeWidth(PIECE_SIZE * 0.03);
        piece.setRadius(PIECE_SIZE);
        piece.setFill(color);
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
