package Server;

import Client.GameServerListener;
import javafx.scene.paint.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static javafx.scene.paint.Color.*;
import static javafx.scene.paint.Color.CHOCOLATE;

public class GameLogicHandler {
    ClientHandler ch;

    public GameLogicHandler(ClientHandler ch){
        this.ch=ch;
        PlayGame();
    }

    private void PlayGame() {

    }
}
