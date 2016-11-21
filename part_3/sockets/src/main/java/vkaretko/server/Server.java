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
            new Server(5000, "c:\\projects").start();
        } catch (IOException ioe) {
            System.out.println("Error while server loading");
        }
    }

    public void start() throws IOException{
        System.out.println("Waiting connection");
        try (ServerSocket servSoc = new ServerSocket(port);
             Socket soc = servSoc.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
             PrintWriter out = new PrintWriter(soc.getOutputStream(), true)) {
            System.out.println("Connection established");
            ActionManager actMan = new ActionManager(in, out, rootDir);
            while (true) {
                String commandLine = in.readLine();
                System.out.println("Received new command from client: " + commandLine);
                actMan.init(commandLine);
            }
        }
    }
}
