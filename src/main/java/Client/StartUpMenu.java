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

public class StartUpMenu {

    String nickname;

    StartUpMenu(Stage primaryStage) {

        /**
         * User's unique nickname - uniqueness will be confirmed!
         */

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

                    label.setText(nickname + " is your nickaname. Trying to connect..."); //TODO Sprawdzenie wyjatkowości nickname na serverze
                    Menu menu = new Menu(primaryStage, nickname);
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
