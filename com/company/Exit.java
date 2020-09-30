package com.company;

import java.io.File;

/** Exit parancs, ennek segítségével lépünk ki */
public class Exit extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Exit(String name) {
        super(name);
    }

    /** Kilépünk a programból */
    public File execute(File wd, String[] cmd) {
        System.exit(0); return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "exit: kilép a programból.";
    }

    /** A parancs neve */
    public String name() {
        return Exit.super.getName();
    }

}
