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
             InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream();
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter sendToServer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connection established, to show commands type -help\r\nEnter command:");
            while (true) {
                sendToServer.println(fromConsole.readLine());
                String answer = fromServer.readLine();
                String[] param = answer.split(" ");
                if (param[0].equals("#rddload")) {
                    byte[] bytes = new byte[16*1024];
                    int count;
                    try (FileOutputStream outFile = new FileOutputStream(param[1])) {
                        while ((count = in.read(bytes)) > 0) {
                            outFile.write(bytes, 0, count);
                        }
                        outFile.flush();
                        System.out.println("Download successful");
                    }
                } else if (answer.split(" ")[0].equals("#rduload")) {

                } else {
                    System.out.println(answer);
                    while (fromServer.ready()) {
                        System.out.println(fromServer.readLine());
                    }
                }
            }
        }
    }

    private void receiveFile(BufferedInputStream in, String path) {
        int bytesRead;
        int current;
        try (FileOutputStream outFile = new FileOutputStream(path)) {
            byte [] buffer  = new byte [16*1024];
            System.out.println("Downloading file...");
            bytesRead = in.read(buffer, 0, buffer.length);
            current = bytesRead;
            do {
                bytesRead = in.read(buffer, current, (buffer.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);
            outFile.write(buffer, 0 , current);
            outFile.flush();
        } catch (IOException ioe) {
            System.out.println("Wrong file name");
        }
    }

    private void sendFIle(BufferedOutputStream out) {

    }
}


