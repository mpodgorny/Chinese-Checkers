package Client;

import Client.Board.FillBoard;
import Client.Players.Player;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameServerListener {
    DataInputStream in;
    DataOutputStream out;
    Stage primaryStage;
    FillBoard fb;

    public GameServerListener(DataInputStream in, DataOutputStream out, Stage primaryStage, FillBoard fb) {
        this.in=in;
        this.out=out;
        this.primaryStage=primaryStage;
        this.fb=fb;
        PlayGame();
    }

    public void PlayGame(){

        while(true){
            String command ="";
            try{command =in.readUTF();}catch(IOException ex){}
            switch(command){
                case "COS":

                    break;

                    default:

                        break;
            }







        }

    }


}
