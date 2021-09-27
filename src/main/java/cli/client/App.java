package cli.client;

import java.io.IOException;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        client client1 = new client();
        client1.connetti();
        client1.comunica();
    }
}
