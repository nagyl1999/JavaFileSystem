package com.company;

import java.io.File;
import java.io.IOException;

/** Parancs interfész, ez biztosítja, hogy minden parancs implementálja az execute metódust */
public interface Command {
    /**
     Végrehajtja a parancsot. Ha módosul a paraméterként
     megkapott mappa (wd), akkor visszatér az új mappával.
     Ha nem módosul, az eredetit adja vissza.
     A cmd tömb tartalmazza a parancs paramétereit, a 0.
     indexű paraméter maga a parancs neve.
     */
    File execute(File wd, String[] cmd) throws CannotDeleteFileException, DirectoryExistsException, CannotChangeDirectoryException, IOException, InsufficientParametersException;
    /**
     Visszatér a parancs leírásával.
     */
    String help();
    /**
     Visszatér a parancs nevével.
     */
    String name();
}
