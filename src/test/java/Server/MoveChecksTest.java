package Server;

import Client.Board.StarBoard;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MoveChecksTest {
    StarBoard board = new StarBoard(121);

    @Test
    public void fullCheck() {
        assertTrue(MoveChecks.fullCheck("abc-12:16-11:15", board));
        assertFalse(MoveChecks.fullCheck("abc-6:6-7:8", board));
    }

    @Test
    public void fullPossibilities() {
        ArrayList<int[]> test = MoveChecks.fullPossibilities(8, 4, board);
        assertTrue(contains(test,new int[] {-1, -1}));
        assertTrue(contains(test,new int[] {9, 3}));
        assertTrue(contains(test,new int[] {10, 4}));
        assertTrue(contains(test,new int[] {9, 5}));
        assertTrue(contains(test,new int[] {7, 5}));
        assertTrue(contains(test,new int[] {6, 4}));

        test = MoveChecks.fullPossibilities(12,16,board);
        assertTrue(contains(test,new int[] {-1, -1}));
        assertTrue(contains(test,new int[] {11, 15}));
        assertTrue(contains(test,new int[] {13, 15}));
    }

    @Test
    public void leftPossibility() {
        int[] test = {10, 8};
        assertTrue(MoveChecks.leftPossibility(12,8,board)[0] == test[0] && MoveChecks.leftPossibility(12,8,board)[1] == test[1]);
        test[0] = 4;
        test[1] = 6;
        assertTrue(MoveChecks.leftPossibility(6,6,board)[0] == test[0] && MoveChecks.leftPossibility(6,6,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.leftPossibility(2,10,board)[0] == test[0] && MoveChecks.leftPossibility(2,10,board)[1] == test[1]);
        assertTrue(MoveChecks.leftPossibility(3,9,board)[0] == test[0] && MoveChecks.leftPossibility(3,9,board)[1] == test[1]);
        assertTrue(MoveChecks.leftPossibility(0,12,board)[0] == test[0] && MoveChecks.leftPossibility(0,12,board)[1] == test[1]);
    }
    @Test
    public void rightPossibility() {
        int[] test = {14, 8};
        assertTrue(MoveChecks.rightPossibility(12,8,board)[0] == test[0] && MoveChecks.rightPossibility(12,8,board)[1] == test[1]);
        test[0] = 20;
        test[1] = 6;
        assertTrue(MoveChecks.rightPossibility(18,6,board)[0] == test[0] && MoveChecks.rightPossibility(18,6,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.rightPossibility(20,8,board)[0] == test[0] && MoveChecks.rightPossibility(20,8,board)[1] == test[1]);
        assertTrue(MoveChecks.rightPossibility(22,10,board)[0] == test[0] && MoveChecks.rightPossibility(22,10,board)[1] == test[1]);
        assertTrue(MoveChecks.rightPossibility(23,11,board)[0] == test[0] && MoveChecks.rightPossibility(23,11,board)[1] == test[1]);
    }

    @Test
    public void upperLeftPossibility() {
        int[] test = {11, 7};
        assertTrue(MoveChecks.upperLeftPossibility(12,8,board)[0] == test[0] && MoveChecks.upperLeftPossibility(12,8,board)[1] == test[1]);
        test[0] = 5;
        test[1] = 5;
        assertTrue(MoveChecks.upperLeftPossibility(6,6,board)[0] == test[0] && MoveChecks.upperLeftPossibility(6,6,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.upperLeftPossibility(8,4,board)[0] == test[0] && MoveChecks.upperLeftPossibility(8,4,board)[1] == test[1]);
        assertTrue(MoveChecks.upperLeftPossibility(0,4,board)[0] == test[0] && MoveChecks.upperLeftPossibility(0,4,board)[1] == test[1]);
        assertTrue(MoveChecks.upperLeftPossibility(20,4,board)[0] == test[0] && MoveChecks.upperLeftPossibility(20,4,board)[1] == test[1]);
    }

    @Test
    public void bottomLeftPossibility() {
        int[] test = {11, 9};
        assertTrue(MoveChecks.bottomLeftPossibility(12,8,board)[0] == test[0] && MoveChecks.bottomLeftPossibility(12,8,board)[1] == test[1]);
        test[0] = 5;
        test[1] = 11;
        assertTrue(MoveChecks.bottomLeftPossibility(6,10,board)[0] == test[0] && MoveChecks.bottomLeftPossibility(6,10,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.bottomLeftPossibility(0,12,board)[0] == test[0] && MoveChecks.bottomLeftPossibility(0,12,board)[1] == test[1]);
        assertTrue(MoveChecks.bottomLeftPossibility(12,16,board)[0] == test[0] && MoveChecks.bottomLeftPossibility(12,16,board)[1] == test[1]);
        assertTrue(MoveChecks.bottomLeftPossibility(8,12,board)[0] == test[0] && MoveChecks.bottomLeftPossibility(8,12,board)[1] == test[1]);
    }

    @Test
    public void upperRightPossibility() {
        int[] test = {13, 7};
        assertTrue(MoveChecks.upperRightPossibility(12,8,board)[0] == test[0] && MoveChecks.upperRightPossibility(12,8,board)[1] == test[1]);
        test[0] = 19;
        test[1] = 5;
        assertTrue(MoveChecks.upperRightPossibility(18,6,board)[0] == test[0] && MoveChecks.upperRightPossibility(18,6,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.upperRightPossibility(16,4,board)[0] == test[0] && MoveChecks.upperRightPossibility(16,4,board)[1] == test[1]);
        assertTrue(MoveChecks.upperRightPossibility(24,4,board)[0] == test[0] && MoveChecks.upperRightPossibility(24,4,board)[1] == test[1]);
        assertTrue(MoveChecks.upperRightPossibility(12,0,board)[0] == test[0] && MoveChecks.upperRightPossibility(12,0,board)[1] == test[1]);
    }

    @Test
    public void bottomRightPossibility() {
        int[] test = {13, 9};
        assertTrue(MoveChecks.bottomRightPossibility(12,8,board)[0] == test[0] && MoveChecks.bottomRightPossibility(12,8,board)[1] == test[1]);
        test[0] = 19;
        test[1] = 11;
        assertTrue(MoveChecks.bottomRightPossibility(18,10,board)[0] == test[0] && MoveChecks.bottomRightPossibility(18,10,board)[1] == test[1]);
        test[0] = -1;
        test[1] = -1;
        assertTrue(MoveChecks.bottomRightPossibility(24,12,board)[0] == test[0] && MoveChecks.bottomRightPossibility(24,12,board)[1] == test[1]);
        assertTrue(MoveChecks.bottomRightPossibility(12,16,board)[0] == test[0] && MoveChecks.bottomRightPossibility(12,16,board)[1] == test[1]);
        assertTrue(MoveChecks.bottomRightPossibility(16,12,board)[0] == test[0] && MoveChecks.bottomRightPossibility(16,12,board)[1] == test[1]);
    }

    public boolean contains(ArrayList<int[]> array, int[] pair){
        for(int i=0; i<array.size(); i++){
            if(array.get(i)[0] == pair[0] && array.get(i)[1] == pair[1])
                return true;
        }
        return false;
    }
}