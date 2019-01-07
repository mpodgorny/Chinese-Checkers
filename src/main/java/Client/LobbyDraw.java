package Client;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LobbyDraw {

    /**
     * constructor
     * @param primaryStage
     * @param message
     */
    public LobbyDraw(Stage primaryStage, String message){
        Scene scene = new Scene(oneLabel(message));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Sets the main label for the lobby
     * @param message
     * @return
     */
    private VBox oneLabel(String message){
        VBox vBox = new VBox(10);
        Label label = new Label(message);
        vBox.getChildren().add(label);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }
}
