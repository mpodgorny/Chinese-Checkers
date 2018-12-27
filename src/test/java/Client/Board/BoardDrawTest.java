package Client.Board;


import org.junit.Test;
import static org.junit.Assert.*;

public class BoardDrawTest {



    @Test
    public void BoardDrawTest() {
        /**
         * Checking if PICES_AMOUNT is correct for design of the board
         */
        BoardDraw bd = new BoardDraw();
        int pieces=bd.PIECES_AMOUNT;
            int count=0;
            int in_line_amount=1;
            while(pieces>0) {
                pieces -= in_line_amount;
                in_line_amount = in_line_amount + 1;
                count++;
            }
        assertEquals(pieces, 0);

    }

}