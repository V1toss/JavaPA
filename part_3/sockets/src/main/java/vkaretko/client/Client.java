package vkaretko.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;

/**
 * The Client class - client side part of the Network file manager.
 * Has the main method for executing program.
 * Always start client after starting server.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public class Client {
    /**
     * Network address of the Server.
     */
    private final String servAddress;
    /**
     * Port of the Server.
     */
    private final int servPort;

    /**
     * The constructor of the Client class.
     * @param serverAddress network address of the Server
     * @param servPort port of the Server
     */
    public Client(String serverAddress, int servPort) {
        this.servAddress = serverAddress;
        this.servPort = servPort;
    }

    /**
     * Main method with default parameters of the server port and address.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        final int serverPort = 5556;
        try {
            new Client("127.0.0.1", serverPort).connectToServer();
        } catch (IOException ioe) {
            System.out.println("Connection not established");
        }
    }

    /**
     * Method for initiating start of the Client connection.
     * Creating socket, connect to the Server and send commands.
     * @throws IOException if connection failed
     */
    private void connectToServer() throws IOException {
        System.out.println(String.format("Connect to server: %s", servAddress));
        try (Socket socket = new Socket(servAddress, servPort);
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter sendToServer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connection established, to show commands type -help\r\nEnter command:");
            while (socket.isConnected()) {
                sendToServer.println(fromConsole.readLine());
                String answer = fromServer.readLine();
                String[] param = answer.split(" ");
                if (param[0].equals("#rddload")) {
                    receiveFile(socket, param[1], Integer.valueOf(param[2]));
                } else if (param[0].equals("#rduload")) {
                    File file = new File(param[1]);
                    sendToServer.println(file.length());
                    sendFile(socket, file);
                } else {
                    System.out.println(answer);
                    while (fromServer.ready()) {
                        System.out.println(fromServer.readLine());
                    }
                }
            }
        }
    }

    /**
     * Service method for receiving file from server.
     * @param socket socket
     * @param pathFile path to save file
     * @param fileSize size of receiving file
     */
    private void receiveFile(Socket socket, String pathFile, int fileSize) {
        int count;
        final int kiloByte = 1024;
        final int countOfKb = 16;
        byte[] bytes = new byte[countOfKb * kiloByte];
        try (FileOutputStream outFile = new FileOutputStream(pathFile)) {
            while (fileSize > 0) {
                count = socket.getInputStream().read(bytes);
                outFile.write(bytes, 0, count);
                outFile.flush();
                fileSize -= count;
            }
            System.out.println(String.format("Downloading %s successful\r\nEnter command:", pathFile));
        } catch (FileNotFoundException ffe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("Error while downloading file");
        }
    }

    /**
     * Service method for sending file to server.
     * @param socket socket
     * @param file file to send
     * @throws IOException if sending file failed
     */
    private void sendFile(Socket socket, File file) throws IOException {
        int count;
        final int kiloByte = 1024;
        final int countOfKb = 16;
        byte[] buffer = new byte[countOfKb * kiloByte];
        try (FileInputStream fileStream = new FileInputStream(file)) {
            long fileSize = file.length();
            while (fileSize > 0) {
                count = fileStream.read(buffer);
                socket.getOutputStream().write(buffer, 0, count);
                socket.getOutputStream().flush();
                fileSize -= count;
            }
            System.out.println(String.format("Upload %s successful\r\nEnter command: ", file.getName()));
        } catch (IOException ioe) {
            System.out.println("File not found on client");
        }
    }
}


