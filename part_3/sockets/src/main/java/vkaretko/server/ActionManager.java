package vkaretko.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Vitoss on 20.11.2016.
 */
public class ActionManager {
    private Action[] actions = new Action[5];
    private DataInputStream in;
    private DataOutputStream out;
    private String rootDir;
    private int position = 0;

    public ActionManager (DataInputStream in, DataOutputStream out, String rootDir) {
        this.in = in;
        this.out = out;
        this.rootDir = rootDir;
        fillActions();
    }

    public void fillActions() {
        this.actions[position++] = new ShowRootList("-show", "To show root path directory write -show");
        this.actions[position++] = new MoveToSubdirectory("-subd", "For moving to subdirectory write -subd");
        this.actions[position++] = new MoveToParentDir("-pdir", "For moving to parent directory write -pdir");
        this.actions[position++] = new DownloadFile("-dload", "For downloading file enter -dload file.xxx path_to_save");
        this.actions[position++] = new UploadFile("-uload", "For uploading file enter -uload path/file.xxx");
    }

    public void init (String commandLine) throws IOException {
        if (commandLine.equals("-help")) {
            showHelp();
        } else {
            Action action = checkAction(commandLine);
            if (action != null) {
                action.execute();
            } else {
                out.writeUTF("Command is undefined, type -help for more information");
            }
        }
    }

    private Action checkAction(String commandLine) {
        String[] param = commandLine.split(" ");
        Action result = null;
        for (Action action : this.actions) {
            if (param[0].equals(action.getKey())) {
                result = action;
            }
        }
        return result;
    }

    public void showHelp() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Action action : this.actions) {
            sb.append(String.format("%s\r\n", action.getInfo()));
        }
        out.writeUTF(sb.toString());
    }

    private class ShowRootList extends Action {
        ShowRootList(String key, String info) {
            super(key, info);
        }

        @Override
        public File execute() throws IOException{
            return null;
        }
    }


    private class UploadFile extends Action {
        UploadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public File execute() {
            return null;
        }
    }

    private class MoveToSubdirectory extends Action {
        MoveToSubdirectory(String key, String info) {
            super(key, info);
        }

        @Override
        public File execute() {
            return null;
        }
    }

    private class MoveToParentDir extends Action {
        MoveToParentDir(String key, String info) {
            super(key, info);
        }

        @Override
        public File execute() {
            return null;
        }
    }

    private class DownloadFile extends Action {
        DownloadFile(String key, String info) {
            super(key, info);
        }

        @Override
        public File execute() {
            return null;
        }
    }


}
