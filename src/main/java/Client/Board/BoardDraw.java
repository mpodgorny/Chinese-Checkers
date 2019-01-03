package Client.Board;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Stack;

public class BoardDraw {

    private StackPane stackPane;

    public BoardDraw(Stage primaryStage, StarBoard board) {
        Scene startup = new Scene(drawTiles(board));
        primaryStage.setScene(startup);
        primaryStage.show();

    }

    private Parent drawTiles(StarBoard board){
        GridPane grid = new GridPane();
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
}
