package Client;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.Socket;


public abstract class AbstractStage {
    static VBox vbButtons = new VBox();
    static Scene scene = new Scene(vbButtons, 500, 500, Color.BLACK);
    static Socket socket;




}
