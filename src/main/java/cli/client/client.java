package cli.client;
import java.io.*;
import java.net.*;


public class client {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket socket;
    BufferedReader tastiera;
    String StringUser = " ";
    String StringReply;
    DataInputStream in;
    DataOutputStream out;   

    protected Socket connetti() throws IOException
    {
        try{
            tastiera = new BufferedReader( new InputStreamReader(System.in));
            socket = new Socket(nomeServer, portaServer);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        }catch (UnknownHostException a){
            System.err.println("");
        }catch (Exception e){
            System.out.println("");
            System.exit(1);
        }
        System.out.println(InetAddress.getLocalHost());
        return socket;
    }
    public void comunica() throws IOException{
        try{
            for(;;){
            System.out.println("4 Inserisci stringa da modificare: "+'\n');
            StringUser = tastiera.readLine();
            System.out.println("5 Invio stringa al server e attendo...");
            out.writeBytes(StringUser+'\n');
            StringReply = in.readLine();
            System.out.println("... risposta dal server "+ '\n'+StringReply);
            if (StringUser == null || StringUser.equals("FINE") || StringUser.equals("STOP")) {
                System.out.println("9 CLI: terminata elaborazione chiusura connessione");
                socket.close();
                break;
            }
        }
        }catch (Exception e){
            socket.close();
            System.exit(1);
        }
    }
}
