package Client.Board;

import Client.GameServerListener;
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

    public String getTypeOfTile() {
        return typeOfTile;
    }

    public void setTypeOfTile(String typeOfTile) {
        this.typeOfTile = typeOfTile;
    }

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
                System.out.println("clicked col: " + column + " row: " +row);
            }
        });

    }
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
                System.out.println("clicked col: " + column + " row: " +row);
            }
        });
    }

    public int getRow(){return row;}
    public int getColumn(){return column;}
    public Tile getTile() {return this;}


}
