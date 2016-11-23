package vkaretko.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public class Server {
    private final int port;
    private final File rootDir;

    public Server (int port, String rootDir) {
        this.port = port;
        this.rootDir = new File(rootDir);
    }

    public static void main(String[] args) {
        try {
            new Server(5556, "c:\\projects").start();
        } catch (IOException ioe) {
            System.out.println("Error while server loading");
        }
    }

    public void start() throws IOException{
        System.out.println("Waiting connection");
        try (ServerSocket servSoc = new ServerSocket(port);
             Socket soc = servSoc.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()))) {
            ActionManager actMan = new ActionManager(soc.getInputStream(), soc.getOutputStream(), rootDir);
            System.out.println("Connection established");
            while (true) {
                String commandLine = reader.readLine();
                System.out.println(String.format("Received new command from client: %s", commandLine));
                actMan.init(commandLine);
            }
        }
    }
}
