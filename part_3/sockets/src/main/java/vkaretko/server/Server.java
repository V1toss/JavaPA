package vkaretko.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
    private final String rootDir;

    public Server (int port, String rootDir) {
        this.port = port;
        this.rootDir = rootDir;
    }

    public static void main(String[] args) {
        try {
            new Server(5000, "folder").start();
        } catch (IOException ioe) {
            System.out.println("Error while server loading");
        }
    }

    public void start() throws IOException{
        System.out.println("Waiting connection");
        try (ServerSocket servSoc = new ServerSocket(port);
             Socket soc = servSoc.accept();
             DataInputStream in = new DataInputStream(soc.getInputStream());
             DataOutputStream out = new DataOutputStream(soc.getOutputStream())) {
            System.out.println("Connection established");
            ActionManager actMan = new ActionManager(in, out, rootDir);
            while (true) {
                String commandLine = in.readUTF();
                System.out.println("Received new command from client: " + commandLine);
                actMan.init(commandLine);
            }
        }
    }
}
