package Client;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.Socket;


public abstract class AbstractStage {
    static VBox vbox = new VBox();
    static Scene scene = new Scene(vbox, 500, 500, Color.BLACK);
    static Socket socket;




}
