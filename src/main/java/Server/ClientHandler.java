package Server;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ClientHandler extends Thread {

    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream in;
    final DataOutputStream out;
    final Socket s;
    String nick;
    Boolean gameOn = false;


    // Constructor
    public ClientHandler(Socket s, DataInputStream in, DataOutputStream out, String nickname)
    {
        this.s = s;
        this.in = in;
        this.out = out;
        this.nick=nickname;
    }

    @Override
    public void run()
    {
        String input ="";
        try { input = in.readUTF();} catch(Exception ex) {}

        if(input=="GAME_FOR_TWO") {
            //hostuj gre dla 2
            if(!gameOn) {
                gameOn=true;

            }
        } else if (input =="GAME_FOR_THREE"){
            //hostuj gre dla 3
            if(!gameOn) {
                gameOn=true;

            }
        } else if (input =="GAME_FOR_FOUR"){
            //hostuj gre dla 4
            if(!gameOn) {
                gameOn=true;

            }
        } else if (input =="GAME_FOR_SIX"){
            //hostuj grę dla 6
            if(!gameOn) {
                gameOn=true;

            }
        } else if (input == "CONNECT_TO_GAME") {
            //dolacz do istniejacej gry
            if(gameOn) {

            }
        } else
            System.out.println("Program shouldn't be here");


    }
}