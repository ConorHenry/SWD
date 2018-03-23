import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Client class implements the client-side of the program for connecting to the server, sending query requesting a
 * file by name, and receiving it's data from the server.
 * @author conorhenry
 */
public class Client{
    /**
     * The address of the server
     */
    private final String serverAddress;

    /**
     * ObjectInputStream object for input from the server
     */
    private ObjectInputStream networkInput;

    /**
     * ObjectInputStream object for output to the server
     */
    private ObjectOutputStream networkOutput;


    /**
     * 1-arg constructor for Client class sets the serverAddress
     * @param serverAddress address of the server to be used in this object
     */
    public Client(String serverAddress)   { this.serverAddress=serverAddress; }

    /**
     * Method to take input from the user in the form of a file name, send that filename to the server, and display the
     * text of the file returned by the server, or display an appropriate message in the event of an error
     */
    public void startTransfer(){
        try {
            System.out.println("Enter a valid filename");
            Scanner userInput=new Scanner(System.in);
            String query =userInput.nextLine();
            //System.out.println(query);
            networkOutput.writeObject(query);
            networkOutput.flush();
            String response="";
            try {
                response = networkInput.readObject().toString();
                System.out.println(response);
                if(response.equals("File retrieved successfully:\n")){
                    receiveData();
                }
            }catch (ClassNotFoundException e) {
                System.out.println("ERROR: Invalid query received");//
                e.printStackTrace();
            }

            if(!response.equals("Error: Requested file could not be located\n")){
                //in the event that neither of the server's two default messages is received
                throw new IOException();
            }
        }catch ( IOException e ) {
            System.out.println("ERROR: Problem establishing or maintaining connection");
            e.printStackTrace();
        }
    }

    /**
     * Method to connect to the server or display an error message in the case of a failed connection
     */
    public void connect(){
        try {
            Socket socket = new Socket(InetAddress.getByName(serverAddress), Server.DEFAULT_PORT);
            networkOutput = new ObjectOutputStream(socket.getOutputStream());
            networkOutput.flush();
            networkInput = new ObjectInputStream(socket.getInputStream());
        }catch(IOException e){
            System.out.println("ERROR: Problem establishing or maintaining connection");
            e.printStackTrace();
        }
    }

    /**
     * method to receive and display the data from the file sent by the server
     * @throws ClassNotFoundException Thrown by readObject() if the Object's class is not recognized
     * @throws IOException //Thrown by networkInput.readObject() if there is a error reading the data stream
     */
    public void receiveData() throws ClassNotFoundException, IOException{
        String message="";
        do{
            System.out.print(message);
            message=networkInput.readObject().toString();

        }while(!message.equals("TransmissionComplete"));
    }

}