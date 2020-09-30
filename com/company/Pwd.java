package com.company;

import java.io.File;

/** Pwd osztály */
public class Pwd extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Pwd(String name) {
        super(name);
    }

    /** Kiírjuk a jelenlegi mappa elérési utját */
    public File execute(File wd, String[] cmd) {
        try {
            System.out.println(wd.getCanonicalPath());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "pwd: kiírja az aktuális könyvtár elérési útját.";
    }

    /** A parancs neve */
    public String name() {
        return Pwd.super.getName();
    }

}
