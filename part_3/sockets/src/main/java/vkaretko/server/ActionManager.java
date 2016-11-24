package vkaretko.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Server class - server side part of the Network file manager.
 * Has the main method for executing program.
 * Always start server before starting client.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public class ActionManager {
    /**
     * Count of actions.
     */
    private final int countOfActions = 5;
    /**
     * Array of available actions.
     */
    private Action[] actions = new Action[countOfActions];
    /**
     * Output stream for sending messages to Client.
     */
    private PrintWriter messageOut;
    /**
     * Input stream for reading messages from Client.
     */
    private BufferedReader messageIn;
    /**
     * Input stream from socket.
     */
    private InputStream in;
    /**
     * Output stream to socket.
     */
    private OutputStream out;
    /**
     * Positions for actions.
     */
    private int position = 0;
    /**
     * Current directory for displaying to user.
     */
    private File currentDir;

    /**
     * The constructor of the ActionManager class.
     * @param in Input stream from socket.
     * @param out Output stream to socket.
     * @param rootDir Root directory on server
     */
    public ActionManager(InputStream in, OutputStream out, File rootDir) {
        this.in = in;
        this.out = out;
        this.currentDir = rootDir;
        this.messageOut = new PrintWriter(out, true);
        this.messageIn = new BufferedReader(new InputStreamReader(in));
        fillActions();
    }

    /**
     * Method to create actions and fill them in array of actions.
     */
    private void fillActions() {
        this.actions[position++] = new ShowRootList("-show", "To show root path directory write -show");
        this.actions[position++] = new MoveToSubdirectory("-subd", "For moving to subdirectory write -subd directory");
        this.actions[position++] = new MoveToParentDir("-pdir", "For moving to parent directory write -pdir");
        this.actions[position++] = new DownloadFile("-dload", "For downloading file enter -dload path_server path_client");
        this.actions[position++] = new UploadFile("-uload", "For uploading file enter -uload path_clent path_server");
    }

    /**
     * Method to initiate ActionManager after Client sending command.
     * @param commandLine command from Client
     * @throws IOException if action failed
     */
    public void init(String commandLine) throws IOException {
        String[] param = commandLine.split(" ");
        if (commandLine.equals("-help")) {
            showHelp();
        } else {
            Action action = checkAction(param[0]);
            if (action != null) {
                action.execute(param);
            } else {
                messageOut.println("Command is undefined, type -help for more information");
            }
        }
    }

    /**
     * Method for selecting action by key.
     * @param command command from Client
     * @return selected action
     */
    private Action checkAction(String command) {
        Action result = null;
        for (Action action : this.actions) {
            if (command.equals(action.getKey())) {
                result = action;
            }
        }
        return result;
    }


    /**
     * Method for displaying help about commands to Client.
     */
    private void showHelp() {
        StringBuilder sb = new StringBuilder();
        for (Action action : this.actions) {
            sb.append(String.format("%s\r\n", action.getInfo()));
        }
        sb.append("Enter command: ");
        messageOut.println(sb.toString());
    }

    /**
     * Private class for Show list of files in current directory.
     */
    private class ShowRootList extends Action {
        /**
         * The constructor of ShowRootList.
         * @param key key of action
         * @param info information about action.
         */
        ShowRootList(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException {
            StringBuilder sb = new StringBuilder();
            for (File file : currentDir.listFiles()) {
                sb.append(String.format("%s\r\n", file.getName()));
            }
            sb.append("Enter command: ");
            messageOut.println(sb.toString());
        }
    }

    /**
     * Private class for upload file from Client.
     */
    private class UploadFile extends Action {
        /**
         * The constructor of UploadFile.
         * @param key key of action
         * @param info information about action.
         */
        UploadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException {
            File file = new File(param[2]);
            messageOut.println(String.format("#rduload %s", param[1]));
            int fileSize = Integer.parseInt(messageIn.readLine());
            try (FileOutputStream outFile = new FileOutputStream(file)) {
                int count;
                final int kiloByte = 1024;
                final int countOfKb = 16;
                byte[] buffer = new byte[countOfKb * kiloByte];
                while (fileSize > 0) {
                    count = in.read(buffer);
                    outFile.write(buffer, 0, count);
                    outFile.flush();
                    fileSize -= count;
                }
                System.out.println(String.format("Upload to server %s successful", file.getName()));
            } catch (IOException ioe) {
                System.out.println("File not found on server");
            }
        }
    }

    /**
     * Private class for moving to subdirectory.
     */
    private class MoveToSubdirectory extends Action {
        /**
         * The constructor of MoveToSubdirectory.
         * @param key key of action
         * @param info information about action.
         */
        MoveToSubdirectory(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException {
            if (!param[1].equals("")) {
                currentDir = new File(String.format("%s\\%s", currentDir.getPath(), param[1]));
                messageOut.println(String.format("Move to subdirectory: %s", currentDir.getPath()));
            } else {
                messageOut.println("Wrong parameter");
            }
        }
    }

    /**
     * Private class for moving to parent directory.
     */
    private class MoveToParentDir extends Action {
        /**
         * The constructor of MoveToParentDir.
         * @param key key of action
         * @param info information about action.
         */
        MoveToParentDir(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException {
            currentDir = new File(currentDir.getParent());
            messageOut.println(String.format("Move to parent directory: %s", currentDir.getPath()));
        }
    }

    /**
     * Private class for download file from Server.
     */
    private class DownloadFile extends Action {
        /**
         * The constructor of DownloadFile.
         * @param key key of action
         * @param info information about action.
         */
        DownloadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) {
            File file = new File(param[1]);
            messageOut.println(String.format("#rddload %s %s", param[2], file.length()));
            try (FileInputStream fileStream = new FileInputStream(file)) {
                int count;
                final int kiloByte = 1024;
                final int countOfKb = 16;
                byte[] buffer = new byte[countOfKb * kiloByte];
                while ((count = fileStream.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                    out.flush();
                }
                System.out.println(String.format("Upload %s successful", file.getName()));
            } catch (IOException ioe) {
                System.out.println("File not found on server");
            }
        }
    }


}
