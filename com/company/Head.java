package com.company;

import java.io.*;
import java.nio.file.Paths;

/** Head osztály, egy fájl n sorának kiiratásáért felelős */
public class Head extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Head(String name) {
        super(name);
    }

    /** Itt olvassuk be, majd írjuk ki a fájlt */
    public File execute(File wd, String[] cmd) throws InsufficientParametersException, IOException {
        /* Ha nincs paraméter, visszatérünk */
        if(cmd.length == 0) throw new InsufficientParametersException("Nem megfelelő paraméterezés!");
        /* Sorok száma */
        int n = 10;
        /* Olvasandó fájl neve */
        String filename = cmd[0];
        /* Van-e n paraméter */
        if(cmd[0].equals("-n")) {
            n = Integer.parseInt(cmd[1]);
            /* Ha van -n paraméter, akkor felülírjuk a korábbi fájl nevét, ami ebben az esetben -n */
            filename = cmd[2];
        }
        /* Fájlnév felülírása teljes elérési útra */
        filename = String.valueOf( Paths.get(wd.getAbsolutePath(), String.join(" ", filename)));
        /* Beolvassuk a fájlt */
        BufferedReader file = new BufferedReader(new FileReader(new File(filename)));
        /* Sort tároló string */
        String line;
        /* Beolvasunk n sort, ha elfogytak a sorok, kilépünk a ciklusból */
        for(int i=0;i<n;i++) {
            /* Következő sor */
            line = file.readLine();
            /* Ha a következő sor létezik, kiírjuk */
            if(line != null) System.out.println(line);
            /* Ha elfogyott, kilépünk */
            else break;
        }
        /* Fájl bezárása */
        file.close();
        /* Visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "head -n <n> <file>: kiírja a <file> nevű fájl első <n> sorát.\n" +
                "Alapértelmezetten 10 sort olvas be a program.";
    }

    /** A parancs neve */
    public String name() {
        return Head.super.getName();
    }

}
