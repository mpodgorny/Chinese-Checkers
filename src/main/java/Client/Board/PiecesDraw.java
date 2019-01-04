package Client.Board;
import Client.Players.Opponent;
import Client.Players.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static Server.ServerMain.board;
import static javafx.scene.paint.Color.*;


public class PiecesDraw {
    private static final Color[] colors = new Color[] {BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    Color color;
    public PiecesDraw(int playerNumber, GridPane grid, Color color) {

        this.color=color;
        System.out.println("Your Color is: " + color);
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
        addInfo(grid);

    }

    public void DrawForTwo(GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(colors[1],"HOME_MIDDLE_TOP",grid);


    }

    public void DrawForThree (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(colors[1],"HOME_LEFT_TOP",grid);
        Opponent op2 = new Opponent(colors[2],"HOME_RIGHT_TOP",grid);


    }

    public void DrawForFour (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_LEFT_DOWN", grid);
        Opponent op1 = new Opponent(colors[1],"HOME_LEFT_TOP",grid);
        Opponent op2 = new Opponent(colors[2],"HOME_RIGHT_TOP",grid);
        Opponent op3 = new Opponent(colors[3],"HOME_RIGHT_DOWN",grid);

    }

    public void DrawForSix (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid);
        Opponent op1 = new Opponent(colors[1],"HOME_MIDDLE_TOP",grid);
        Opponent op2 = new Opponent(colors[2],"HOME_LEFT_TOP",grid);
        Opponent op3 = new Opponent(colors[3],"HOME_RIGHT_TOP",grid);
        Opponent op4 = new Opponent(colors[4],"HOME_LEFT_DOWN",grid);
        Opponent op5 = new Opponent(colors[5],"HOME_RIGHT_DOWN",grid);

    }

    public void addInfo(GridPane grid) {
    Label label = new Label("Your color: " + color);
    grid.setConstraints(label, 0,0);
    grid.getChildren().add(label);
    }

}
