package com.company;

import java.io.File;
import java.util.Arrays;

/** Ls osztály, segítségével kilistázhatjuk a jelenlegi mappa tartalmát */
public class Ls extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Ls(String name) {
        super(name);
    }

    /** Mappa kilistázása */
    public File execute(File wd, String[] cmd) {
        /* Végigmegyünk a kilistázott fájlokon */
        for(String name : wd.list()) {
            /* Ha a parancs tartalmazza a -l flaget... */
            if(cmd.length > 0 && Arrays.asList(cmd).contains("-l")) {
                /* Név méret típus */
                System.out.println(String.format("%s\t%s\t%s", name, (new File(name)).length(), ((new File(name)).isDirectory()) ? "-d" : "-f"));
            /* Egyébként kiírjuk a nevét */
            }else System.out.println(name);
        }
        /* Visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "ls: kilistázza az aktuális könyvtárban levő fájlok és könyvtárak neveit.\n" +
                "lehetséges paraméterek:\n" +
                "-l: mint a fenti, de a listában megjeleníti a fájlok méretét és típusát\n" +
                "(d - könyvtár, f - sima fájl)";
    }

    /** A parancs neve */
    public String name() {
        return Ls.super.getName();
    }

}
