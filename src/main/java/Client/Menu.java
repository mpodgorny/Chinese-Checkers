package Client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Menu extends AbstractStage {

    Stage primaryStage;

    /**
     * constructor
     * @param primaryStage
     * @param nickname
     * @param in
     * @param out
     * @param socket
     */
    public Menu(Stage primaryStage, String nickname, DataInputStream in, DataOutputStream out, Socket socket) {

        this.in = in;
        this.out = out;
        this.socket = socket;
        this.nickname = nickname;
        this.primaryStage = primaryStage;
        scene.setFill(Color.BLACK);

        final Label label = new Label("Welcome, " + nickname +".\n Choose option: ");
        vbox.getChildren().add(label);
        MenuButtons btns = new MenuButtons(nickname, in, out, this.primaryStage, socket);
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
