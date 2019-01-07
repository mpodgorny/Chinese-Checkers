package Client.Board;

import javafx.scene.paint.Color;

public class StarBoard {
    private final int tilesCount;
    private final int piecesCount;
    private final int homeLines;
    private final int height;
    private final int width;
    public static int TILE_RADIUS;
    private Tile[][] board;

    /**
     * constructor
     * @param tilesCount
     */
    public StarBoard(int tilesCount){
        this.tilesCount = tilesCount;
        piecesCount = ((tilesCount - 1) / 12);
        homeLines = (int)(Math.sqrt((8*((tilesCount-1)/12)+1))-1)/2;
        height = 4*homeLines+1;
        width = 6*homeLines+1;
        TILE_RADIUS = 20;
        board = new Tile[width][height];
        makeBoard(homeLines);
        //simpleCheck();
    }

    /**
     * uses methods for drawing the full board
     * @param size
     */
    private void makeBoard(int size){
        fillInverseTriangle(size, 0, size,"HOME_LEFT_TOP");
        fillInverseTriangle(size, 4*size+2, size, "HOME_RIGHT_TOP");
        fillInverseTriangle(size, 2*size+1, 3*size+1, "HOME_MIDDLE_DOWN");
        fillTriangle(size, 2*size+1, size-1, "HOME_MIDDLE_TOP");
        fillTriangle(size, 0, 3*size, "HOME_LEFT_DOWN");
        fillTriangle(size, 4*size+2, 3*size, "HOME_RIGHT_DOWN");
        fillHexagon(size+1, 2*size, size);
        fillGhosts();
    }

    /**
     * fills the array for empty spaces(without tile)
     */
    private void fillGhosts(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[j][i]==null) {
                    Tile tile = new Tile(j, i);
                    tile.setTypeOfTile("GHOST");
                    board[j][i] = tile;
                }
            }
        }
    }

    /**
     * creates triangle "house" for pieces
     * @param size
     * @param x
     * @param y
     * @param Type
     */
    private void fillInverseTriangle(int size, int x, int y, String Type ){
        int count = size;
        for(int i=y; i<size+y; i++){
            int tempX = x + size - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i);
                tile.setTypeOfTile(Type);
                board[tempX][i] = tile;
                tempX = tempX + 2;
            }
            count--;
        }
    }

    /**
     * creates triangle house for pieces
     * @param size
     * @param x
     * @param y
     * @param Type
     */
    private void fillTriangle(int size, int x, int y, String Type){
        int count = size;
        for(int i=y; i>y-size; i--){
            int tempX = x + size - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i);
                tile.setTypeOfTile(Type);
                board[tempX][i] = tile;
                tempX = tempX + 2;
            }
            count--;
        }
    }

    /**
     * creates hexagon middle of the board
     * @param side
     * @param x
     * @param y
     */
    private void fillHexagon(int side, int x, int y){
        int count = side;
        boolean theSwitch = false;
        for(int i = y; i<y-1+side*2; i++){
            int tempX = x + side - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i, Color.LIGHTGRAY);
                tile.setTypeOfTile("MIDDLE");
                board[tempX][i] = tile;
                tempX = tempX + 2;
            }
            if(count == (side*2-1))
                theSwitch = true;
            if(theSwitch)
                count--;
            else
                count++;
        }
    }

    /**
     * method (currently not used) for checking the drawing methods
     */
    public void simpleCheck(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[j][i].getTypeOfTile().contains("HOME"))
                    System.out.print("o");
                else if(board[j][i].getTypeOfTile()=="MIDDLE")
                    System.out.print("x");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }
}
