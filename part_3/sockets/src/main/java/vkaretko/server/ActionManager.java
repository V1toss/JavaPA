package vkaretko.server;

import java.io.*;

/**
 * Created by Vitoss on 20.11.2016.
 */
public class ActionManager {
    private Action[] actions = new Action[5];
    private BufferedReader in;
    private PrintWriter out;
    private int position = 0;
    private File currentDir;
    private File rootDir;

    public ActionManager (BufferedReader in, PrintWriter out, File rootDir) {
        this.in = in;
        this.out = out;
        this.rootDir = rootDir;
        this.currentDir = rootDir;
        fillActions();
    }

    public void fillActions() {
        this.actions[position++] = new ShowRootList("-show", "To show root path directory write -show");
        this.actions[position++] = new MoveToSubdirectory("-subd", "For moving to subdirectory write -subd directory");
        this.actions[position++] = new MoveToParentDir("-pdir", "For moving to parent directory write -pdir");
        this.actions[position++] = new DownloadFile("-dload", "For downloading file enter -dload file.xxx path_to_save");
        this.actions[position++] = new UploadFile("-uload", "For uploading file enter -uload path/file.xxx");
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
                out.println("Command is undefined, type -help for more information");
                out.flush();
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
        out.println(sb.toString());
        out.flush();
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
            out.println(sb.toString());
            out.flush();
        }
    }


    private class UploadFile extends Action {
        UploadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) {
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
                out.println(String.format("Move to subdirectory: %s", currentDir.getPath()));
            } else {
                out.println("Wrong parameter");
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
            out.println(String.format("Move to parent directory: %s", currentDir.getPath()));
        }
    }

    private class DownloadFile extends Action {
        DownloadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public void execute(String[] param) {
        }
    }


}
