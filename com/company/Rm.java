package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/** rm osztály, fileok törléséért felelős */
public class Rm extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Rm(String name) {
        super(name);
    }

    /** Kitöröljük a paraméterként kapott fájlt */
    public File execute(File wd, String[] cmd) throws InsufficientParametersException, CannotDeleteFileException {
        /* Ha nincs paraméter, visszatérünk */
        if(cmd.length == 0) throw new InsufficientParametersException("Nem megfelelő paraméterezés!");
        /* A törlendő fájl elérési útja */
        Path filePath = Paths.get(wd.getAbsolutePath(), String.join(" ", cmd));
        /* Megpróbáljuk törölni, ha nem sikerül, akkor kivételt dobunk */
        if(!new File(String.valueOf(filePath)).delete()) throw new CannotDeleteFileException("A fájl nem lehet törölni!");
        /* Kiírjuk, hogy sikeres volt */
        System.out.println(String.format("%s törölve!", String.join(" ", cmd)));
        /* Visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "rm <file>: törli a <file> nevű fájlt.";
    }

    /** A parancs neve */
    public String name() {
        return Rm.super.getName();
    }

}
