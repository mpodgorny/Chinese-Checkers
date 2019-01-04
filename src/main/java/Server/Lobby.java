package Server;

import java.util.ArrayList;

public class Lobby {
    private ArrayList<String> nicknames;
    private int numberOfPlayers;

    public Lobby(ArrayList<String> nicknames, int numberOfPlayers){
        this.nicknames = nicknames;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void addPlayer(String player) {
        nicknames.add(player);
        if (numberOfPlayers == nicknames.size())
            ServerMain.startGame();
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public ArrayList<String> getNicknames() {
        return nicknames;
    }
}
