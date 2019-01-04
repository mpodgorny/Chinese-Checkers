package Client.Board;
import Client.Players.Opponent;
import Client.Players.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static Server.ServerMain.board;


public class PiecesDraw {

    public PiecesDraw(int playerNumber, GridPane grid) {
        switch (playerNumber) {
            case 2:
                DrawForTwo(grid);
                break;
            case 3:
                DrawForThree(grid);
                break;
            case 4:
                DrawForFour(grid);
                break;
            case 6:
                DrawForSix(grid);
                break;
        }

    }

    public void DrawForTwo(GridPane grid) {
        Player pl = new Player(Color.BLUE, "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(Color.RED,"HOME_MIDDLE_TOP",grid);


    }

    public void DrawForThree (GridPane grid) {
        Player pl = new Player(Color.BLUE, "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(Color.RED,"HOME_LEFT_TOP",grid);
        Opponent op2 = new Opponent(Color.YELLOW,"HOME_RIGHT_TOP",grid);


    }

    public void DrawForFour (GridPane grid) {
        Player pl = new Player(Color.BLUE, "HOME_LEFT_DOWN", grid);
        Opponent op1 = new Opponent(Color.GREEN,"HOME_LEFT_TOP",grid);
        Opponent op2 = new Opponent(Color.RED,"HOME_RIGHT_TOP",grid);
        Opponent op3 = new Opponent(Color.YELLOW,"HOME_RIGHT_DOWN",grid);

    }

    public void DrawForSix (GridPane grid) {
        Player pl = new Player(Color.BLUE, "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(Color.RED,"HOME_MIDDLE_TOP",grid);
        Opponent op2 = new Opponent(Color.YELLOW,"HOME_LEFT_TOP",grid);
        Opponent op3 = new Opponent(Color.GREEN,"HOME_RIGHT_TOP",grid);
        Opponent op4 = new Opponent(Color.CHOCOLATE,"HOME_LEFT_DOWN",grid);
        Opponent op5 = new Opponent(Color.AZURE,"HOME_RIGHT_DOWN",grid);

    }


}
