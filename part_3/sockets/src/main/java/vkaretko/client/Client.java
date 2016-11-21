package vkaretko.client;

import java.io.*;
import java.net.Socket;

/**
 * Client class.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public class Client {
    private final String servAddress;
    private final int servPort;

    public Client (String serverAddress, int servPort) {
        this.servAddress = serverAddress;
        this.servPort = servPort;
    }

    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 5000).connectToServer();
        } catch (IOException ioe) {
            System.out.println("Connection not established");
        }
    }

    private void connectToServer() throws IOException {
        System.out.println(String.format("Connect to server: %s", servAddress));
        try (Socket socket = new Socket(servAddress, servPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connection established, to show commands type -help\r\nEnter command:");
            while (true) {
                String lineToSend = reader.readLine();
                out.println(lineToSend);
                String answer = in.readLine();
                System.out.println(answer);
                while (in.ready()) {
                    System.out.println(in.readLine());
                }
            }
        }
    }
}


