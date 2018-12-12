package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MenuButtons extends AbstractStage{

    MenuButtons() {
        vbButtons.getChildren().add(btnForTwoPlayers());
        vbButtons.getChildren().add(btnForThreePlayers());
        vbButtons.getChildren().add(btnForFourPlayers());
        vbButtons.getChildren().add(btnForSixPlayers());
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0, 20, 10, 20));
        vbButtons.setAlignment(Pos.CENTER);

    }




    Button btnForTwoPlayers() {
        Button btn = new Button ("2 players");
        //btn.setStyle("-fx-background-color: gray; ");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("GAME_FOR_TWO");

            }
        });
        return btn;

    }

    Button btnForThreePlayers() {
        Button btn = new Button ("3 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("GAME_FOR_THREE");

            }
        });
        return btn;

    }
    Button btnForFourPlayers() {
        Button btn = new Button ("4 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("GAME_FOR_FOUR");

            }
        });
        return btn;

    }
    Button btnForSixPlayers() {
        Button btn = new Button ("6 players");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("GAME_FOR_SIX");

            }
        });
        return btn;

    }



}
