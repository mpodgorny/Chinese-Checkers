package Client.Board;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardDraw {

    /**
     * Variable TILES_COUNT makes the board scalable - JUnit tests
     * if this nr is valid, then rest of variables is set according to TILES_COUNT
     * @param TILES_COUNT;
     */
    public static final int TILES_COUNT = 121;

    /**
     * Holds information how many pieces there are for player, according to board scale.
     * @param PIECES_AMOUNT
     */
    public static int PIECES_AMOUNT = ((TILES_COUNT - 1) / 12);

    /**
     * Holds number of lines for home tiles; also, how many tiles there are in longest line of home
     * @param HOME_LINES
     */
    public static int HOME_LINES= (int)(Math.sqrt((8*((TILES_COUNT-1)/12)+1))-1)/2;

    /**
     * Creates coordinates and Array of tiles for our board.
     */
    public static int HEIGHT = 4*HOME_LINES +1;
    public static int WIDTH = 6*HOME_LINES+1;
    public static final int TILE_RADIUS = 20;
    private Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();


    public BoardDraw(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(10);
        grid.setHgap(30);

        for(int y=HEIGHT-1;y>=0;y--) {
            if(y>=HEIGHT-HOME_LINES) {
                int temp = HEIGHT - HOME_LINES;
                    Tile tile = new Tile(14, y);
                    board[14][y] = tile;
                    GridPane.setConstraints(tile, 14, y);
                    GridPane.setColumnSpan(tile, 14);
                    grid.getChildren().add(tile);
                } else if (y==12) {
                for(int i =2;i<27;i+=2) {
                    Tile tile = new Tile(i,y);
                    GridPane.setConstraints(tile, i, y);
                    GridPane.setColumnSpan(tile, i);
                    grid.getChildren().add(tile);
                }
            }

        }
        Scene startup = new Scene(grid, 400, 350);

        primaryStage.setScene(startup);
        primaryStage.show();
    }

    private void Draw() {

    }

}
