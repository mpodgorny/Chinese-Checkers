package Client.Board;
import org.junit.Test;

import static java.lang.Math.floor;
import static org.junit.Assert.*;

public class BoardDrawTest {
    BoardDraw bd;
    double temp;
    double nr_of_lines;


    @Test
    public void NumberOfTilesTest() {

        nr_of_lines=(Math.sqrt((8*((bd.TILES_COUNT-1.0)/12.0)+1))-1)/2;
        temp = floor(nr_of_lines);
        assertEquals(nr_of_lines, temp, 0);
        }

    }