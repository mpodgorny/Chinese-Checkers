package Server;

import Client.Board.StarBoard;
import Client.Board.Tile;

import java.util.ArrayList;

public class MoveChecks {

    public static int fullCheck(String formattedMove, StarBoard board){
        String[] components = formattedMove.split("-");
        int startColumn = Integer.parseInt(components[1].split(":")[0]);
        int startRow = Integer.parseInt(components[1].split(":")[1]);
        int endColumn = Integer.parseInt(components[2].split(":")[0]);
        int endRow = Integer.parseInt(components[2].split(":")[1]);

        ArrayList<int[]> possibilities = fullPossibilities(startColumn, startRow, board);
        for(int i=0; i<possibilities.size(); i++){
            if(possibilities.get(i)[0] == endColumn && possibilities.get(i)[1] == endRow) {
                if(board.getBoard()[startColumn][startRow].getPiece().getGoalHouse()
                        == board.getBoard()[startColumn][startRow].getTypeOfTile()) {
                    if(board.getBoard()[endColumn][endRow].getTypeOfTile()
                            == board.getBoard()[startColumn][startRow].getTypeOfTile()) {
                        if (possibilities.get(i)[2] == 1)
                            return 2;
                        return 1;
                    }else{
                        return 0;
                    }
                }else{
                    if (possibilities.get(i)[2] == 1)
                        return 2;
                    return 1;
                }
            }
        }
        return 0;
    }

    public static ArrayList<int[]> fullPossibilities(int column, int row, StarBoard board){
        ArrayList<int[]> possibilities = new ArrayList<>();
        possibilities.add(leftPossibility(column, row, board, 0));
        possibilities.add(bottomLeftPossibility(column, row, board, 0));
        possibilities.add(upperLeftPossibility(column, row, board, 0));
        possibilities.add(rightPossibility(column, row, board, 0));
        possibilities.add(bottomRightPossibility(column, row, board, 0));
        possibilities.add(upperRightPossibility(column, row, board, 0));

        return possibilities;
    }

    public static int[] leftPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column-2 < 0 || board.getBoard()[column-2][row].getTypeOfTile() == "GHOST") {
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column-2][row].hasPiece()){
            return leftPossibility(column-2, row, board, 1);
        }else{
            int[] cords = {column-2, row, jumpOver};
            return cords;
        }
    }

    public static int[] rightPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column+2 > board.getWidth()-1 || board.getBoard()[column+2][row].getTypeOfTile() == "GHOST") {
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column+2][row].hasPiece()){
            return rightPossibility(column+2, row, board, 1);
        }else{
            int[] cords = {column+2, row, jumpOver};
            return cords;
        }
    }

    public static int[] upperLeftPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column-1 < 0 || row-1 < 0 || board.getBoard()[column-1][row-1].getTypeOfTile() == "GHOST"){
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column-1][row-1].hasPiece()) {
            return upperLeftPossibility(column - 1, row - 1, board, 1);
        }else{
            int[] cords = {column-1, row-1, jumpOver};
            return cords;
        }
    }

    public static int[] bottomLeftPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column-1 < 0 || row+1 > board.getHeight()-1 || board.getBoard()[column-1][row+1].getTypeOfTile() == "GHOST") {
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column-1][row+1].hasPiece()){
            return bottomLeftPossibility(column-1, row+1, board, 1);
        }else{
            int[] cords = {column-1, row+1, jumpOver};
            return cords;
        }
    }

    public static int[] upperRightPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column+1 > board.getWidth()-1 || row-1 < 0 || board.getBoard()[column+1][row-1].getTypeOfTile() == "GHOST"){
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column+1][row-1].hasPiece()) {
            return upperRightPossibility(column + 1, row - 1, board, 1);
        }else{
            int[] cords = {column+1, row-1, jumpOver};
            return cords;
        }
    }

    public static int[] bottomRightPossibility(int column, int row, StarBoard board, int jumpOver){
        if(column+1 > board.getWidth()-1 || row+1 > board.getHeight()-1 || board.getBoard()[column+1][row+1].getTypeOfTile() == "GHOST"){
            int[] nuller = {-1, -1};
            return nuller;
        }else if(board.getBoard()[column+1][row+1].hasPiece()){
            return bottomRightPossibility(column+1, row+1, board, 1);
        }else{
            int[] cords = {column+1, row+1, jumpOver};
            return cords;
        }
    }
}
