package Client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Menu extends AbstractStage {


    public Menu(Stage primaryStage) {



        MenuButtons btns = new MenuButtons();

        scene.setFill(Color.BLACK);

        primaryStage.setTitle("TrylmaAlpha");
        primaryStage.setScene(scene);
        primaryStage.show();

    }





}
