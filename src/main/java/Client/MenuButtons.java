package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MenuButtons extends AbstractStage{


    private static int PORT = 2308;
    private Socket socket;
    private BufferedReader in;
    PrintWriter out = null;


    MenuButtons() {
//niepoitrzebne??
        try {
            socket = new Socket("localhost", PORT);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception ex) {}

        vbox.getChildren().add(btnForTwoPlayers());
        vbox.getChildren().add(btnForThreePlayers());
        vbox.getChildren().add(btnForFourPlayers());
        vbox.getChildren().add(btnForSixPlayers());
        vbox.getChildren().add(btnForConnecting());
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 20, 10, 20));
        vbox.setAlignment(Pos.CENTER);

    }
//TODO przejrzystsza implementacja przycisków xd

//TODO jeśli gra istnieje, nie pozwól dołączyć

    Button btnForTwoPlayers( ) {
        Button btn = new Button ("2 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                out.println("GAME_FOR_TWO");

            }
        });
        return btn;

    }

    Button btnForThreePlayers() {
        Button btn = new Button ("3 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                out.println("GAME_FOR_THREE");

            }
        });
        return btn;

    }
    Button btnForFourPlayers() {
        Button btn = new Button ("4 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                out.println("GAME_FOR_FOUR");

            }
        });
        return btn;

    }
    Button btnForSixPlayers() {
        Button btn = new Button ("6 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                out.println("GAME_FOR_SIX");

            }
        });
        return btn;

    }
    //TODO czy gra istnieje? IF EXISTS THEN połącz, ELSE komunikat NO_ROOM_IN_PROGRES.
    Button btnForConnecting() {
        Button btn = new Button ("Connect to Exisiting Game");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                out.println("CONNECT_TO_GAME");

            }
        });
        return btn;

    }

}
