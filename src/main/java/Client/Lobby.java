package Client;

import Client.Board.FillBoard;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.DataInputStream;


public class Lobby {

    //Test jest na grze dla 6 graczy, odpala ale zawiesza się póki co

    public Lobby(Stage primaryStage, String nick, int numberOfPlayers, DataInputStream in) {
        String nickNames[] = new String[numberOfPlayers];
        nickNames[0]=nick;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        Label label = new Label("Welcome " + nick + ".\nWaiting for other players.");
        grid.setConstraints(label, 0,9);
        grid.getChildren().add(label);
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TrylmaAlpha");
        primaryStage.show();

        int i =1;
        while(i<numberOfPlayers) {
            try {
                nickNames[i] = in.readUTF();
                Label labelPlayer = new Label("Player " + nickNames[i] + " is connected.");
                grid.setConstraints(labelPlayer, 0, i);
                grid.getChildren().add(labelPlayer);
                i++;
            }catch(Exception ex) {
                System.out.println("coś jest nie tak");
            }

        }

        FillBoard fb = new FillBoard(numberOfPlayers,primaryStage);

    }

}
