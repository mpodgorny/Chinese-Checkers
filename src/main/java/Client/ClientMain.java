package Client;

import Client.Board.BoardDraw;
import Client.Board.StarBoard;
import javafx.application.Application;
import javafx.stage.Stage;


public class ClientMain extends Application {

    @Override
    public void start(Stage primaryStage) {


        BoardDraw bd = new BoardDraw(primaryStage);
        //StartUpMenu start = new StartUpMenu(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
