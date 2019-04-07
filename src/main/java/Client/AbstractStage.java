package Client;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public abstract class AbstractStage {
    static VBox vbox = new VBox();
    static Scene scene = new Scene(vbox, 500, 500, Color.BLACK);
    static Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    public String nickname;
    public Stage primaryStage;

    public DataInputStream getInStream(){return this.in;}
    public DataOutputStream getOutStream(){return this.out;}
    public Socket getSocket(){return this.socket;}
    public Stage getStage(){return this.primaryStage;}



}
