package Client;

import javafx.application.Platform;

import java.io.*;


/**
 * This will control all actions from server, should contain board and pieces etc.
 *
 */
public class ServerListener extends Thread {

    private Menu menu;
    private DataOutputStream output;
    private DataInputStream input;
    private boolean Disconnected;
    private boolean isHosting=false;

    public ServerListener(Menu menu) {
        this.menu= menu;
        output = menu.getOutStream();
        input = menu.getInStream();
    }

    @Override
    public void run() {
        String message = "";
        while (true) {
            try {
                message = input.readUTF();
            } catch (IOException ex) {}


            switch (message) {

                case "UNABLE":
                 System.out.println("i znowu");
                    break;
                case "HOST_FOR_TWO":

                    break;

                case "HOST_FOR_THREE":

                    break;

                case "HOST_FOR_FOUR":

                    break;

                case "HOST_FOR_SIX":

                    break;

                case "CONNECT":

                    break;

                default:
                    break;

            }
        }

    }

}
