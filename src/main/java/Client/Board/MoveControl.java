package Client.Board;

public class MoveControl {
    private static String move;
    private static boolean moveDone = false;
    private static boolean moveCorrect = false;

    public static String getMove() {
        return move;
    }

    public static void setMove(String move) {
        MoveControl.move = move;
    }

    public static boolean isMoveDone() {
        return moveDone;
    }

    public static void setMoveDone(boolean moveDone) {
        MoveControl.moveDone = moveDone;
    }

    public static boolean isMoveCorrect() {
        return moveCorrect;
    }

    public static void setMoveCorrect(boolean moveCorrect) {
        MoveControl.moveCorrect = moveCorrect;
    }
}
