package com.company;

import java.io.*;
import java.nio.file.Paths;

/** Cp osztály, fájlok másolásáért felelős */
public class Cp extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Cp(String name) {
        super(name);
    }

    /** Itt másoljuk át a fájlt */
    public File execute(File wd, String[] cmd) throws InsufficientParametersException, IOException {
        /* Ha nincs paraméter, visszatérünk */
        if(cmd.length != 2) throw new InsufficientParametersException("Nem megfelelő paraméterezés!");
        /* Input */
        FileInputStream file1 = new FileInputStream(String.valueOf(Paths.get(wd.getAbsolutePath(), cmd[0])));
        /* Output */
        FileOutputStream file2 = new FileOutputStream(String.valueOf(Paths.get(wd.getAbsolutePath(), cmd[1])));
        /* Byte count, ekkora méretű egy blokk, befolyásolja a foglalt memória méretét */
        int byteCount = 1024;
        /* Byte tömb */
        byte[] bytes = new byte[byteCount];
        /* Blokk beolvasása, írása */
        while(file1.available() > 0) {
            bytes = file1.readNBytes(byteCount);
            file2.write(bytes);
        }
        /* Input bezárása */
        file1.close();
        /* Output bezárása */
        file2.close();
        /* Visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "cp <file1> <file2>: <file1>-et átmásolja <file2>-be.";
    }

    /** A parancs neve */
    public String name() {
        return Cp.super.getName();
    }

}
