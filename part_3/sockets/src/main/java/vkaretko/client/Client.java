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
            new Client("127.0.0.1", 5556).connectToServer();
        } catch (IOException ioe) {
            System.out.println("Connection not established");
        }
    }

    private void connectToServer() throws IOException {
        System.out.println(String.format("Connect to server: %s", servAddress));
        try (Socket socket = new Socket(servAddress, servPort);
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter sendToServer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connection established, to show commands type -help\r\nEnter command:");
            while (true) {
                sendToServer.println(fromConsole.readLine());
                String answer = fromServer.readLine();
                String[] param = answer.split(" ");
                if (param[0].equals("#rddload")) {
                    receiveFile(socket, param[1], Integer.valueOf(param[2]));
                } else if (param[0].equals("#rduload")) {
                    sendFile(socket, param[1]);
                } else {
                    System.out.println(answer);
                    while (fromServer.ready()) {
                        System.out.println(fromServer.readLine());
                    }
                }
            }
        }
    }

    private void receiveFile(Socket socket, String pathFile, int fileSize) {
        byte[] bytes = new byte[16 * 1024];
        int count;
        try (FileOutputStream outFile = new FileOutputStream(pathFile)) {
            while (fileSize > 0) {
                count = socket.getInputStream().read(bytes);
                outFile.write(bytes, 0, count);
                outFile.flush();
                fileSize -= count;
            }
            System.out.println(String.format("Downloading %s successful\r\nEnter command: ", pathFile));
        } catch (FileNotFoundException ffe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("Error while downloading file");
        }
    }

    private void sendFile(Socket socket, String pathFile) throws IOException {
        File file = new File(pathFile);
        int count;
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             FileInputStream fileStream = new FileInputStream(file)) {
            writer.println(file.length());
            writer.close();
            byte[] buffer = new byte[16 * 1024];
            long fileSize = file.length();
            while (fileSize > 0) {
                count = fileStream.read(buffer);
                socket.getOutputStream().write(buffer, 0, count);
                fileSize -= count;

            }
            System.out.println(String.format("Upload %s successful", file.getName()));
        } catch (IOException ioe) {
            System.out.println("File not found on client");
        }
    }
}


