package vkaretko.server;

import java.io.*;

/**
 * Created by Vitoss on 20.11.2016.
 */
public class ActionManager {
    private Action[] actions = new Action[5];
    private PrintWriter messageOut;
    private BufferedReader messageIn;
    private InputStream in;
    private OutputStream out;
    private int position = 0;
    private File currentDir;

    public ActionManager (InputStream in, OutputStream out, File rootDir) {
        this.in = in;
        this.out = out;
        this.currentDir = rootDir;
        this.messageOut = new PrintWriter(out, true);
        this.messageIn = new BufferedReader(new InputStreamReader(in));
        fillActions();
    }

    public void fillActions() {
        this.actions[position++] = new ShowRootList("-show", "To show root path directory write -show");
        this.actions[position++] = new MoveToSubdirectory("-subd", "For moving to subdirectory write -subd directory");
        this.actions[position++] = new MoveToParentDir("-pdir", "For moving to parent directory write -pdir");
        this.actions[position++] = new DownloadFile("-dload", "For downloading file enter -dload path_file path_to_save");
        this.actions[position++] = new UploadFile("-uload", "For uploading file enter -uload path_file path_to_save");
    }

    public void init (String commandLine) throws IOException {
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

    private Action checkAction(String command) {
        Action result = null;
        for (Action action : this.actions) {
            if (command.equals(action.getKey())) {
                result = action;
            }
        }
        return result;
    }

    private void showHelp() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Action action : this.actions) {
            sb.append(String.format("%s\r\n", action.getInfo()));
        }
        sb.append("Enter command: ");
        messageOut.println(sb.toString());
    }

    private class ShowRootList extends Action {
        ShowRootList(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException{
            StringBuilder sb = new StringBuilder();
            for (File file : currentDir.listFiles()) {
                sb.append(String.format("%s\r\n", file.getName()));
            }
            messageOut.println(sb.toString());
        }
    }


    private class UploadFile extends Action {
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
                byte[] buffer = new byte[16 * 1024];
                while (fileSize > 0){
                    count = in.read(buffer);
                    outFile.write(buffer, 0, count);
                    outFile.flush();
                    fileSize -= count;
                    System.out.println(fileSize);
                }
                System.out.println(String.format("Upload to server %s successful", file.getName()));
            } catch (IOException ioe) {
                System.out.println("File not found on server");
            }
        }
    }

    private class MoveToSubdirectory extends Action {
        MoveToSubdirectory(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException{
            if (!param[1].equals("")) {
                currentDir = new File(String.format("%s\\%s", currentDir.getPath(), param[1]));
                messageOut.println(String.format("Move to subdirectory: %s", currentDir.getPath()));
            } else {
                messageOut.println("Wrong parameter");
            }
        }
    }

    private class MoveToParentDir extends Action {
        MoveToParentDir(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) throws IOException{
            currentDir = new File(currentDir.getParent());
            messageOut.println(String.format("Move to parent directory: %s", currentDir.getPath()));
        }
    }

    private class DownloadFile extends Action {
        DownloadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) {
            File file = new File (param[1]);
            messageOut.println(String.format("#rddload %s %s", param[2], file.length()));
            try (FileInputStream fileStream = new FileInputStream(file)){
                int count;
                byte[] buffer = new byte[16 * 1024];
                while( (count = fileStream.read(buffer) ) > 0 ){
                    out.write(buffer, 0, count);
                    out.flush();
                }
                System.out.println(String.format("Upload %s successful", file.getName()));
                messageOut.println("Enter command: ");
            } catch (IOException ioe) {
                System.out.println("File not found on server");
            }
        }
    }


}
