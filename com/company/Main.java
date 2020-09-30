package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/** Főosztály */
public class Main {
    /** Parancsok referenciáit sztring alapján tároló hashmap, statikus */
    public static HashMap<String, Command> parancsok;

    /** Itt állítjuk be a parancsok referenciáit, majd rendeljük őket egy sztringhez */
    public static void setParancsok() {
        parancsok = new HashMap<>();

        Main.parancsok.put("cd", new Cd("cd"));
        Main.parancsok.put("cp", new Cp("cp"));
        Main.parancsok.put("ls", new Ls("ls"));
        Main.parancsok.put("rm", new Rm("rm"));
        Main.parancsok.put("pwd", new Pwd("pwd"));
        Main.parancsok.put("exit", new Exit("exit"));
        Main.parancsok.put("head", new Head("head"));
        Main.parancsok.put("help", new Help("help"));
        Main.parancsok.put("mkdir", new Mkdir("mkdir"));
        Main.parancsok.put("reclist", new Reclist("reclist"));
    }

    /** Beolvassa a parancsot, és darabolt formában visszaadja */
    public static String[] getCommand() {
        return (new Scanner(System.in)).nextLine().split(" ", 0);
    }

    /** Kiírja a mostani mappa elérési útját */
    public static void printPreline(File wd) {
        System.out.print(String.format("user@%s: ", wd.getAbsolutePath()));
    }

    /** Fő metódus, itt olvassuk be a parancsokat */
    public static void main(String[] args) {
        /* Mindenkori working dir */
        File wd = new File(System.getProperty("user.dir"));
        /* command, stdin-ről olvassuk be */
        String[] cmd;

        Main.setParancsok();
        while(true) {
            Main.printPreline(wd);
            cmd = Main.getCommand();

            try {
                /* Ha van ilyen parancs, lefuttatjuk, és felülírjuk a jelenlegi mappát */
                wd = Main.parancsok.get(cmd[0]).execute(wd, Arrays.copyOfRange(cmd, 1, cmd.length)); //Levágjuk a parancsot a tömb elejéről
            }catch(NullPointerException n) {
                /* Ha nincs ilyen parancs */
                System.out.println("Ilyen parancs nem található!");
            }catch(Exception e) {
                /* Egyéb hiba */
                System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
            }
        }
    }
}
