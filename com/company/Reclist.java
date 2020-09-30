package com.company;

import java.io.File;

/** Reclist osztály, egy adott mappa rekurzív bejárásáért felelős */
public class Reclist extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Reclist(String name) {
        super(name);
    }

    /** Itt járjuk be */
    private void lsdir(File wd, String tab) {
        /* Mappa tartalmának listába rendezése */
        File[] list = wd.listFiles();
        /* Végigmegyünk a listán */
        for(File file : list) {
            /* Tab + elem neve */
            System.out.println(tab+file.getName());
            /* Ha az adott elem egy mappa, akkor kilistázzuk annak a tartalmát is */
            if(file.isDirectory()) this.lsdir(file, tab+" ");
        }
    }

    /** Meghívja a bejáró metódust */
    public File execute(File wd, String[] cmd) {
        this.lsdir(wd, "");
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "reclist: rekurzívan kilistázza a könyvtár tartalmát.";
    }

    /** A parancs neve */
    public String name() {
        return Reclist.super.getName();
    }

}
