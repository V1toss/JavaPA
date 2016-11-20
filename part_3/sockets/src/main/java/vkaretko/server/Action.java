package vkaretko.server;

import java.io.File;
import java.io.IOException;

/**
 * Created by Vitoss on 20.11.2016.
 */
public abstract class Action {
    private String key;
    private String info;

    Action(String key, String info) {
        this.key = key;
        this.info = info;
    }

    String getKey() {
        return this.key;
    }

    String getInfo() {
        return this.info;
    }

    public abstract File execute() throws IOException;
}
