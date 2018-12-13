package Client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Menu extends AbstractStage {

    public Menu(Stage primaryStage, String nickname, DataInputStream in, DataOutputStream out) {



        final Label label = new Label("Welcome, " + nickname +".\n \b\b\b\bChoose option: ");
        vbox.getChildren().add(label);
        MenuButtons btns = new MenuButtons(nickname, in, out);


        scene.setFill(Color.BLACK);

        primaryStage.setTitle("TrylmaAlpha");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() { //kod do "czystego" wyjścia z programu za pomocą "X" w górnym prawym rogu.
            @Override
            public void handle(WindowEvent t) {

                Platform.exit();
                System.exit(0);
            }
        });


    }





}