package com.company;

import java.io.File;

/** Help osztály, a parancsokhoz tartozó segítő leírás megjelenítéséért felelős */
public class Help extends Name implements Command {
    /** A konstruktorban kapja a nevét a parancs */
    public Help(String name) {
        super(name);
    }

    /** Kilistázza az elérhető parancsok neveit */
    private void listCommands() {
        /* Végigfutunk a Main osztály publikus parancsok hashmap-jén */
        for(String name : Main.parancsok.keySet()) {
            /* Kiírjuk az adott parancs nevét */
            System.out.println(name);
        }
    }

    /** Kiírja az elérhető parancsok neveit, ha kap paramétert akkor az adott parancs leírását */
    public File execute(File wd, String[] cmd) {
        /* Ha nem kapott paramétert akkor kiírja az elérhető parancsok neveit */
        if(cmd.length == 0) this.listCommands();
        /* Egyéb esetben a paraméterként kapott parancs help text-jét, ha cmd.length > 1, figyelmen kívül hagyja a többi paramétert */
        else System.out.println(Main.parancsok.get(cmd[0]).help());
        /* Visszatérünk */
        return wd;
    }

    /** A parancs leírása */
    public String help() {
        return "help <parancs1>: Kiírja az elérhető parancsok neveit, ha kap paramétert akkor az adott parancs leírását.";
    }

    /** A parancs neve */
    public String name() {
        return Help.super.getName();
    }

}
