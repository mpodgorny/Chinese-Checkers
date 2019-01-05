package Client;

import Client.Board.FillBoard;
import Client.Board.Piece;
import Client.Board.Tile;
import Client.Players.Player;
import javafx.scene.paint.Color;
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
    Tile tempTile;
    int numberOfPlayers;
    Color color;


    public GameServerListener(DataInputStream in, DataOutputStream out, FillBoard fb, int numberOfPlayers) {
        System.out.println("Tworze game serrver Listener");
        this.in=in;
        this.out=out;
        this.primaryStage=primaryStage;
        this.fb=fb;
        this.numberOfPlayers=numberOfPlayers;
        PlayGame(numberOfPlayers);
        this.color=fb.color;
    }

    public void PlayGame(int numberOfPlayers){

        switch(numberOfPlayers){
            case 2:
                System.out.println("Gra dla 2 sie rozpoczela.");

                break;
            case 3:

                break;
            case 4:

                break;
            case 6:

                break;
        }

    }

    public void gameForTwo(){
        int nrCurrentColor = 0;
        while(true) {
            try {
                nrCurrentColor = in.read();
            } catch (IOException e) {
            }
            switch (nrCurrentColor) {
                case 0:
            }
        }
    }

    public void gameForThree() {

    }

    public void gameForFour() {

    }

    public void gameForSix(){


    }





    public static Piece chosenPiece(Piece piece){

        return piece;
    }
    public  Tile chosenTile(Tile tile) {
        this.tempTile=tile;
        return tile;
    }
    public void move(Piece piece){
        fb.grid.setConstraints(piece,tempTile.column,tempTile.row);

    }

}
