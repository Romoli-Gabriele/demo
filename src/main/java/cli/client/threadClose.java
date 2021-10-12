package cli.client;

import java.net.*;
import java.io.*;

public class threadClose extends Thread {

    DataInputStream in;
    client cli;
    String reply;

    public threadClose(DataInputStream in, client cli) {
        this.in = in;
        this.cli = cli;
    }

    public void run() {
        for (;;) {
            try {
                reply = in.readLine();
                if (reply.equals("close")) {
                    System.out.println("Server disconnesso, chiusura client..");
                    System.exit(1);
                }else{
                    cli.StringReply = reply;
                }
            } catch (IOException e) {
                
            }
        }
    }

}