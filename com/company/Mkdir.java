package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Mkdir osztály, új mappa létrehozásáért felelős */
public class Mkdir extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Mkdir(String name) {
        super(name);
    }

    /** Itt hozzuk létre az új mappát */
    public File execute(File wd, String[] cmd) throws InsufficientParametersException, DirectoryExistsException {
        /* Ha nincs paraméter, visszatérünk */
        if(cmd.length == 0) throw new InsufficientParametersException("Nem megfelelő paraméterezés!");
        /*  új mappa elérési útjának létrehozása */
        Path folderPath = Paths.get(wd.getAbsolutePath(), String.join(" ", cmd));
        /* Ha létezik, kivételt dobunk */
        if((new File(String.valueOf(folderPath))).exists()) throw new DirectoryExistsException("A mappa már létezik!");
        /* Létrehozzuk a mappát, ha nem sikerült, jelezzük */
        if(!(new File(String.valueOf(folderPath))).mkdir()) System.out.println("A mappát nem sikerült létrehozni!");
        /* visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "mkdir <dir>: létrehozza az aktuális könyvtárban a <dir> nevű könvytárat.";
    }

    /** A parancs neve */
    public String name() {
        return Mkdir.super.getName();
    }

}
