package Client.Board;

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


    public BoardDraw() {

    }

    private void Draw() {

    }

}
