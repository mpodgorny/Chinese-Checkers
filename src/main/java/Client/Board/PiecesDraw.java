package Client.Board;

import com.sun.org.apache.xerces.internal.dom.ChildNode;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static Client.Board.BoardDraw.*;

public class PiecesDraw {
  public PiecesDraw(int playerNumber, Scene scene) {
        switch (playerNumber) {
            case 2:
                DrawForTwo();
                break;
            case 3:
                DrawForThree();
                break;
            case 4:
                DrawForFour();
                break;
            case 6:
                DrawForSix();
                break;
        }

    }


    public void DrawForTwo() {

    }
        public void DrawForThree () {

        }
        public void DrawForFour () {

        }
        public void DrawForSix () {

        }
}
