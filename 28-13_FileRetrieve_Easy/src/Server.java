
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Server class implements the server-side behavior of getting input from the client, locating the specified file, and
 * sending the data contained back to the client
 * @author conorhenry
 */
public class Server {
    /**
     * The default port number for the connection
     */
    public static final int DEFAULT_PORT = 23500;

    /**
     * Socket for connecting to client
     */
    private ServerSocket server;

    /**
     * Filename specified by client
     */
    private String fileName;

    /**
     * no-arg constructor for Server objects. Binds to the specified port.
     */
    public Server() {
        try {
            server = new ServerSocket(DEFAULT_PORT, 10);
        }      catch(IOException e) {
            System.out.println("ERROR: Problem binding to port");
            e.printStackTrace();
        }
    }

    /**
     * Method to receive a query from the client and initiate the transfer of data
     */
    public void startTransfer() {
        try {
            Socket socket = server.accept();
            System.out.println("Connection Successful");//
            ObjectOutputStream networkOutput = new ObjectOutputStream(socket.getOutputStream());
            networkOutput.flush();
            ObjectInputStream networkInput = new ObjectInputStream(socket.getInputStream());
            try {
                fileName = networkInput.readObject().toString();
                System.out.println("User requested file: "+fileName);//
            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: Invalid query received");//
                e.printStackTrace();
            }

            File requestedFile = new File(fileName);
            if (requestedFile.exists()) {
                sendData(networkOutput,requestedFile);

            } else {
                System.out.println("ERROR: File Not Found");
                networkOutput.writeObject("Error: Requested file could not be located\n");
                networkOutput.flush();
            }
        } catch(IOException e) {
            System.out.println("ERROR: Problem establishing or maintaining connection");
            e.printStackTrace();
        }
    }

    /**
     * Method to transfer the data contained in the file to the user
     * @param output the ObjectOutputStream used to send data to the client
     * @param file the file to extract data from
     * @throws IOException in the case of an error with fileIO or writing to output
     */
    public void sendData(ObjectOutputStream output,File file) throws IOException{
        output.writeObject("File Retrieved Successfully\n");
        output.flush();
        Scanner fileStream = new Scanner(new FileInputStream(file));
        while (fileStream.hasNext()) {
            output.writeObject(fileStream.nextLine());
            output.flush();
        }
        output.writeObject("TransmissionComplete");
        output.flush();
        fileStream.close();
        System.out.println("File Sent Successfully");
    }
}
