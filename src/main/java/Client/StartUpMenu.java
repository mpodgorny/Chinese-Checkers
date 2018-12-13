package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.Boolean.TRUE;

public class StartUpMenu {

    /**
     * User's unique nickname - uniqueness will be confirmed!
     */

    String nickname;

    /**
     * Creates startup window, ask for a nickname, check if there is no player with this nickname
     * already on the server, establish connection and open game menu.
     * @param primaryStage
     */
    StartUpMenu(Stage primaryStage) {


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final Label label = new Label("tu bedzie tekst o udanym polaczeniu ");
        GridPane.setConstraints(label, 0, 15);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        final Label welcome_txt = new Label ("Welcome to Trylma: the Chinese Checkers.\n Please, enter your nickname and connect to the server.");
        GridPane.setConstraints(welcome_txt, 1, 1);
        grid.getChildren().add(welcome_txt);


        final TextField name = new TextField();
        name.setPrefColumnCount(10);
        GridPane.setConstraints(name, 1, 7);
        grid.getChildren().add(name);
        Scene startup = new Scene(grid, 400, 350, Color.BLACK);
        Button submit = new Button("Connect");
        GridPane.setConstraints(submit, 1, 10);
        grid.getChildren().add(submit);

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if ((name.getText() != null && !name.getText().isEmpty())) {
                    nickname = name.getText();

                    label.setText(nickname + " is your nickaname. Trying to connect...");

                    //próba podłączenia uzywajac nickname
                    try {
                        InetAddress ip = InetAddress.getByName("localhost"); //pobranie ip hosta
                        Socket s = new Socket(ip, 2308);

                        DataInputStream in = new DataInputStream(s.getInputStream());
                        DataOutputStream out = new DataOutputStream(s.getOutputStream());

                        out.writeUTF(nickname);

                        if (in.readBoolean() ==TRUE) {
                            Menu menu = new Menu(primaryStage, nickname, in, out); //w tym miejscu podłączylismy się do serwera, mamy indiwidualny in, out oraz nickname.
                        } else {
                            label.setText(nickname + " is taken! Please choose another one");
                        }

                    } catch (Exception ex) {}



                } else {
                    label.setText("You have not chosed nickname.");
                }
            }
        });

        primaryStage.setTitle("TrylmaAlpha");

        primaryStage.setScene(startup);
        primaryStage.show();
    }
}