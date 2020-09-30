package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Cd osztály, segítségével lépkedhetünk a mappák között */
public class Cd extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Cd(String name) {
        super(name);
    }

    /** Mappát váltunk */
    public File execute(File wd, String[] cmd) throws InsufficientParametersException, CannotChangeDirectoryException {
        /* Ha nincs paraméter, visszatérünk */
        if(cmd.length == 0) throw new InsufficientParametersException("Nem megfelelő paraméterezés!");
        /* Ha a paraméter .., akkor visszalépünk */
        if(cmd[0].equals("..")) return new File(wd.getParent());
        /* Létezik-e a kért mappa */
        Path newPath = Paths.get(wd.getAbsolutePath(), String.join(" ", cmd));
        /* Ha nem létezik, visszatérünk */
        if(!Files.exists(newPath) || !Files.isDirectory(newPath)) throw new CannotChangeDirectoryException("A mappa nem létezik!");
        /* Egyéb esetben belépünk a kért mappába */
        return new File(String.valueOf(newPath));
    }

    /** A parancs leírása */
    public String help() {
        return "cd <dir>: az aktuális könyvtárból átlép a benne levő, <dir> nevű alkönyvtárba. Ha\n" + "" +
                "<dir> értéke \"..\", akkor egy szinttel feljebb lép";
    }

    /** A parancs neve */
    public String name() {
        return Cd.super.getName();
    }

}
