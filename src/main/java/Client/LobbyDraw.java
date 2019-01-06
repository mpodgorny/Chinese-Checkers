package Client;

import Server.Lobby;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LobbyDraw {
    public LobbyDraw(Stage primaryStage, Lobby lobby){
        Scene scene = new Scene(setLabels(lobby));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public LobbyDraw(Stage primaryStage, String message){
        Scene scene = new Scene(oneLabel(message));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox setLabels(Lobby lobby){
        VBox vBox = new VBox(10);
        for(int i=0; i<lobby.getNicknames().size(); i++){
            Label label = new Label(lobby.getNicknames().get(i) + " is ready!");
            vBox.getChildren().add(label);
        }
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private VBox oneLabel(String message){
        VBox vBox = new VBox(10);
        Label label = new Label(message);
        vBox.getChildren().add(label);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
