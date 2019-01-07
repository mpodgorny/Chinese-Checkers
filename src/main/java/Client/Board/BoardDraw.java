package Client.Board;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;

public class BoardDraw {
    private static GridPane grid;
    private static StarBoard board;

    public BoardDraw(Stage primaryStage, StarBoard board) {
        this.board = board;
        Scene startup = new Scene(drawTiles(board));
        primaryStage.setScene(startup);
        primaryStage.show();
    }

    private Parent drawTiles(StarBoard board){
        GridPane grid = new GridPane();
        this.grid = grid;
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(2);
        grid.setHgap(-16);
        for(int i=0; i<board.getHeight(); i++){
            for(int j=0; j<board.getWidth(); j++){
                if(board.getBoard()[j][i].getTypeOfTile()!="GHOST") {
                    GridPane.setConstraints(board.getBoard()[j][i], j, i);
                    grid.getChildren().add(board.getBoard()[j][i]);
                }
            }
        }
        return grid;
    }

    public GridPane getGrid() {return this.grid;}

    public static void drawSkipButton(DataOutputStream out){
        Button button = new Button("Skip Turn");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    out.writeUTF("SKIP_TURN");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Double width = board.getWidth()*0.90;
        Double height = board.getHeight()*0.90;
        grid.setConstraints(button, width.intValue(), height.intValue(), 10, 1);
        grid.getChildren().add(button);
    }

    public static void drawInfoLabel(String info, int column, int row, Color color){
        Label label = new Label(info);
        label.setTextFill(color);
        grid.setConstraints(label, column, row, 10, 1);
        grid.getChildren().add(label);
    }

    public static void drawBoardAccessories(DataOutputStream out, Color color){
        BoardDraw.drawSkipButton(out);
        Double a = board.getWidth()*0.10;
        Double b = board.getHeight()*0.90;
        BoardDraw.drawInfoLabel("Your color", a.intValue(), b.intValue(), color);
    }
}
