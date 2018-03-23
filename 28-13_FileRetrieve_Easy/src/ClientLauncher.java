/**
 * Driver for Client class, connects to the server and runs the startTransfer() method
 * @author conorhenry
 */
public class ClientLauncher {

    public static void main( String args[] )   {
        Client client = new Client("127.0.0.1");
        client.connect();
        client.startTransfer();
    }
}
