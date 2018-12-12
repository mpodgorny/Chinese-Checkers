package Client;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class ClientMain extends Application {


    @Override
    public void start(Stage primaryStage) {
        Menu menu = new Menu(primaryStage);

    }

    public static void main(String[] args) {


        launch(args);

    }
}
