package Client;

import Client.Board.BoardDraw;
import Server.ServerMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class MenuButtons extends AbstractStage{
    DataInputStream in;
    DataOutputStream out;


    MenuButtons(String nickname, DataInputStream in, DataOutputStream out, Stage primaryStage) {
        this.in =in;
        this.out=out;

        vbox.getChildren().add(btnForTwoPlayers(primaryStage));
        vbox.getChildren().add(btnForThreePlayers(primaryStage));
        vbox.getChildren().add(btnForFourPlayers(primaryStage));
        vbox.getChildren().add(btnForSixPlayers(primaryStage));
        vbox.getChildren().add(btnForConnecting());
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 20, 10, 20));
        vbox.setAlignment(Pos.CENTER);

    }
//TODO przejrzystsza implementacja przycisków xd

//TODO jeśli gra istnieje, nie pozwól stworzyć nową

    Button btnForTwoPlayers(Stage primaryStage) {
        Button btn = new Button ("2 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_TWO");} catch (Exception ex) {}
                BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);

            }
        });
        return btn;

    }

    Button btnForThreePlayers(Stage primaryStage) {
        Button btn = new Button ("3 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_THREE");} catch (Exception ex) {}
                BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);


            }
        });
        return btn;

    }
    Button btnForFourPlayers(Stage primaryStage) {
        Button btn = new Button ("4 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_FOUR");} catch (Exception ex) {}
                BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);


            }
        });
        return btn;

    }
    Button btnForSixPlayers(Stage primaryStage) {
        Button btn = new Button ("6 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try { out.writeUTF("GAME_FOR_SIX");} catch (Exception ex) {}
                BoardDraw bd = new BoardDraw(primaryStage, ServerMain.board);


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
                try { out.writeUTF("CONNECT_TO_GAME");} catch (Exception ex) {}

            }
        });
        return btn;

    }

}
