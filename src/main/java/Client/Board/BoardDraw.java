package Client.Board;

public class BoardDraw {

    public static final int HEIGHT = 17;
    public static final int WIDHT = 25;
    public static final int TILE_RADIUS = 20;
    public static final int PIECES_AMOUNT = 10; //TODO: assert czy liczba moze być trójkątem na planszy (1,3,6,10, itp).

    public BoardDraw() {

    }

    private void Draw(){


    }

    /**
     * Counts how many lines is required for "home" tiles where pieces are in the beginning
     * Serves purpose for future modification of board.
     * @return
     */
    private int Lines_For_Pieces_Home() { //TODO: JUNIT assercja z TODO wyzej: czy koncowe pieces < 0
        int pieces=PIECES_AMOUNT;
        int count=0;
        int in_line_amount=1;
        while(pieces>0) {
            pieces -= in_line_amount;
            in_line_amount = in_line_amount + 1;
            count++;
        }
    return count;
    }

}
