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
    public static final int TILE_RADIUS = 15;
    /**
     * Added 1 to becouse of clarity - when tile is x=14 y = 17 then we
     * dont have to interpret it in array-style counting (from 0)
     */
    private Tile[][] board = new Tile[WIDTH+1][HEIGHT+1];

    private Group tileGroup = new Group();
    private static final int indentation = 10;

    public BoardDraw(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        //grid.setVgap(1);
        //grid.setHgap(5);

        DrawHomeTilesUpsideDown(2, 4, grid);
        DrawHomeTilesUpsideDown(20, 4, grid);
        DrawHomeTilesUpsideDown(11, 13, grid);

        DrawHomeTiles(14,17,grid);
        //DrawHomeTiles(5,8,grid);
        //DrawHomeTiles(23,8,grid);
        Scene startup = new Scene(grid, 400, 350);
        primaryStage.setScene(startup);
        primaryStage.show();
    }

    private void DrawHomeTilesUpsideDown(int startX, int startY, GridPane grid) {

        for(int y=startY;y>=startY-HOME_LINES;y--) {
            int tempStart=startX;
            for(int x=startY-y;x>=0;x--) {
                Tile tile = new Tile(tempStart, y);
                //board[tempStart][y] = tile;
                GridPane.setConstraints(tile, tempStart+indentation, y);
                grid.getChildren().add(tile);
                tempStart+=2;
            }
            startX--;
        }
    }

    private void DrawHomeTiles(int startX, int startY, GridPane grid) {

        for(int y=startY;y>=startY-HOME_LINES;y--) {
            int tempStart = startX;
            for(int x=0;x<=startY-y;x++) {
                Tile tile = new Tile(tempStart+indentation, y);
                //board[tempStart][y] = tile;
                GridPane.setConstraints(tile, tempStart+indentation, y);
                grid.getChildren().add(tile);
                tempStart+=2;
            }
            startX--;
        }
    }
}
