package Client.Board;

public class StarBoard {
    private final int tilesCount;
    private final int piecesCount;
    private final int homeLines;
    private final int height;
    private final int width;
    private int tileRadius;
    private Tile[][] board;

    public StarBoard(int tilesCount){
        this.tilesCount = tilesCount;
        piecesCount = ((tilesCount - 1) / 12);
        homeLines = (int)(Math.sqrt((8*((tilesCount-1)/12)+1))-1)/2;
        height = 4*homeLines+1;
        width = 6*homeLines+1;
        tileRadius = 20;
        board = new Tile[width][height];
        makeBoard(homeLines);
        simpleCheck();
    }

    private void makeBoard(int size){
        fillInverseTriangle(size, 0, size);
        fillInverseTriangle(size, 4*size+2, size);
        fillInverseTriangle(size, 2*size+1, 3*size+1);
        fillTriangle(size, 2*size+1, size-1);
        fillTriangle(size, 0, 3*size);
        fillTriangle(size, 4*size+2, 3*size);
        fillHexagon(size+1, 2*size, size);
        fillGhosts();
    }

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

    private void fillInverseTriangle(int size, int x, int y){
        int count = size;
        for(int i=y; i<size+y; i++){
            int tempX = x + size - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i);
                tile.setTypeOfTile("HOME");
                board[tempX][i] = tile;
                tempX = tempX + 2;
            }
            count--;
        }
    }

    private void fillTriangle(int size, int x, int y){
        int count = size;
        for(int i=y; i>y-size; i--){
            int tempX = x + size - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i);
                tile.setTypeOfTile("HOME");
                board[tempX][i] = tile;
                tempX = tempX + 2;
            }
            count--;
        }
    }

    private void fillHexagon(int side, int x, int y){
        int count = side;
        boolean theSwitch = false;
        for(int i = y; i<y-1+side*2; i++){
            int tempX = x + side - count;
            for(int j=0; j<count; j++){
                Tile tile = new Tile(tempX, i);
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

    private void simpleCheck(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(board[j][i].getTypeOfTile()=="HOME")
                    System.out.print("o");
                else if(board[j][i].getTypeOfTile()=="MIDDLE")
                    System.out.print("x");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
