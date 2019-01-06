package Client.Board;
import Client.Players.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.paint.Color.*;


public class PiecesDraw {
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static final Color[] colors = new Color[] {BLUE, RED, GREEN, YELLOW, AZURE, CHOCOLATE};
    Color color;
    private StarBoard board;
    public PiecesDraw(int playerNumber, GridPane grid, Color color, StarBoard board) {

        this.color=color;
        this.board = board;
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
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid, "HOME_MIDDLE_TOP", board);
        Player op1 = new Player(colors[1],"HOME_MIDDLE_TOP",grid, "HOME_MIDDLE_DOWN", board);
        players.add(pl);
        players.add(op1);
    }

    public void DrawForThree (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid, "HOME_MIDDLE_TOP", board);
        Player op1 = new Player(colors[1],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN", board);
        Player op2 = new Player(colors[2],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN", board);
        players.add(pl);
        players.add(op1);
        players.add(op2);
    }

    public void DrawForFour (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_LEFT_DOWN", grid,"HOME_RIGHT_TOP", board);
        Player op1 = new Player(colors[1],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN", board);
        Player op2 = new Player(colors[2],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN", board);
        Player op3 = new Player(colors[3],"HOME_RIGHT_DOWN",grid,"HOME_LEFT_TOP", board);
        players.add(pl);
        players.add(op1);
        players.add(op2);
        players.add(op3);
    }

    public void DrawForSix (GridPane grid) {
        Player pl = new Player(colors[0], "HOME_MIDDLE_DOWN", grid,"HOME_MIDDLE_TOP", board);
        Player op1 = new Player(colors[1],"HOME_MIDDLE_TOP",grid,"HOME_MIDDLE_DOWN", board);
        Player op2 = new Player(colors[2],"HOME_LEFT_TOP",grid,"HOME_RIGHT_DOWN", board);
        Player op3 = new Player(colors[3],"HOME_RIGHT_TOP",grid,"HOME_LEFT_DOWN", board);
        Player op4 = new Player(colors[4],"HOME_LEFT_DOWN",grid,"HOME_RIGHT_TOP", board);
        Player op5 = new Player(colors[5],"HOME_RIGHT_DOWN",grid,"HOME_LEFT_TOP", board);
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

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}