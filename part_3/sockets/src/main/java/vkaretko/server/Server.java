package vkaretko.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class - server side part of the Network file manager.
 * Has the main method for executing program.
 * Always start server before starting client.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public class Server {
    /**
     * Port of the server.
     */
    private final int port;
    /**
     * Root directory of the server.
     */
    private final File rootDir;

    /**
     * The constructor of the Server class.
     *
     * @param port connection port to the server
     * @param rootDir root directory for server after executing
     */
    public Server(int port, String rootDir) {
        this.port = port;
        this.rootDir = new File(rootDir);
    }

    /**
     * Main method with default parameters of port and root directory.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        final int port = 5556;
        try {
            new Server(port, "c:\\").start();
        } catch (IOException ioe) {
            System.out.println("Error while server loading");
        }
    }

    /**
     * Method for initiating start of the server.
     * Creating socket, waiting for connection and commands from client.
     * @throws IOException if connection failed
     */
    public void start() throws IOException {
        System.out.println("Waiting connection");
        try (ServerSocket servSoc = new ServerSocket(port);
             Socket soc = servSoc.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()))) {
            ActionManager actMan = new ActionManager(soc.getInputStream(), soc.getOutputStream(), rootDir);
            System.out.println("Connection established");
            while (soc.isConnected()) {
                String commandLine = reader.readLine();
                System.out.println(String.format("Received new command from client: %s", commandLine));
                actMan.init(commandLine);
            }
        }
    }
}
