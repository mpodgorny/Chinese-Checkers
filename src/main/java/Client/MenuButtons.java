package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class MenuButtons extends AbstractStage{

    /**
     * fields necessary to send signals to server's threads
     */
    DataOutputStream out;
    String nickname;
    Socket socket;

    /**
     * constructor
     * @param nickname of a player
     * @param in
     * @param out
     * @param primaryStage
     * @param socket
     */
    MenuButtons(String nickname, DataInputStream in, DataOutputStream out, Stage primaryStage, Socket socket) {
        this.in =in;
        this.out=out;
        this.nickname=nickname;
        this.socket = socket;
        vbox.getChildren().add(btnForTwoPlayers(primaryStage));
        vbox.getChildren().add(btnForThreePlayers(primaryStage));
        vbox.getChildren().add(btnForFourPlayers(primaryStage));
        vbox.getChildren().add(btnForSixPlayers(primaryStage));
        vbox.getChildren().add(btnForConnecting());
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 20, 10, 20));
        vbox.setAlignment(Pos.CENTER);

    }

    /**
     * button handles the creation of game for 2 players
     * @param primaryStage
     * @return
     */
    Button btnForTwoPlayers(Stage primaryStage) {
        Button btn = new Button ("2 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_TWO");} catch (Exception ex) {}
            }
        });
        return btn;

    }

    /**
     * button handles the creation of game for 3 players
     * @param primaryStage
     * @return
     */
    Button btnForThreePlayers(Stage primaryStage) {
        Button btn = new Button ("3 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_THREE");} catch (Exception ex) {}
            }
        });
        return btn;

    }

    /**
     * button handles the creation of game for 4 players
     * @param primaryStage
     * @return
     */
    Button btnForFourPlayers(Stage primaryStage) {
        Button btn = new Button ("4 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_FOUR");} catch (Exception ex) {}
            }
        });
        return btn;

    }

    /**
     * button handles the creation of game for 6 players
     * @param primaryStage
     * @return
     */
    Button btnForSixPlayers(Stage primaryStage) {
        Button btn = new Button ("6 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_SIX");} catch (Exception ex) {}
            }
        });
        return btn;

    }

    /**
     * button that handles the connection to an existing game
     * @return
     */
    Button btnForConnecting() {
        Button btn = new Button ("Connect to Exisiting Game");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("CONNECT_TO_GAME");} catch (Exception ex) {}
            }
        });
        return btn;

    }

}
