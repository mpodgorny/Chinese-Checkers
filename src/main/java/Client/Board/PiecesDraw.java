package Client.Board;
import Client.Players.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;


public class PiecesDraw {
    static List<Player> players = new ArrayList<Player>();
    private static final Color[] colors = new Color[] {BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    Color color;
    public PiecesDraw(int playerNumber, GridPane grid, Color color) {

        this.color=color;
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
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid, "HOME_MIDDLE_TOP");
        Player op1 = new Player(colors[1],"HOME_MIDDLE_TOP",grid, "HOME_MIDDLE_DOWN");
        players.add(pl);
        players.add(op1);


    }

    public void DrawForThree (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid, "HOME_MIDDLE_TOP");
        Player op1 = new Player(colors[1],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN");
        Player op2 = new Player(colors[2],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN");
        players.add(pl);
        players.add(op1);
        players.add(op2);


    }

    public void DrawForFour (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_LEFT_DOWN", grid,"HOME_RIGHT_TOP");
        Player op1 = new Player(colors[1],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN");
        Player op2 = new Player(colors[2],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN");
        Player op3 = new Player(colors[3],"HOME_RIGHT_DOWN",grid,"HOME_LEFT_TOP");
        players.add(pl);
        players.add(op1);
        players.add(op2);
        players.add(op3);

    }

    public void DrawForSix (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid,"HOME_MIDDLE_TOP");
        Player op1 = new Player(colors[1],"HOME_MIDDLE_TOP",grid,"HOME_MIDDLE_DOWN");
        Player op2 = new Player(colors[2],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN");
        Player op3 = new Player(colors[3],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN");
        Player op4 = new Player(colors[4],"HOME_LEFT_DOWN",grid,"HOME_RIGHT_TOP");
        Player op5 = new Player(colors[5],"HOME_RIGHT_DOWN",grid,"HOME_LEFT_TOP");
        players.add(pl);
        players.add(op1);
        players.add(op2);
        players.add(op3);
        players.add(op4);
        players.add(op5);

    }

    public void addInfo(GridPane grid) {
        Label label = new Label("Your color");
        label.setTextFill(color);
        grid.setConstraints(label,12,16, 50,32);
        grid.getChildren().add(label);

    }

}
