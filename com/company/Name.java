package com.company;

/** Absztrakt Name osztály, mivel minden parancs osztályhoz tartozik egy név, egy közös ős fogja tárolni */
public abstract class Name {
    /** A parancs neve */
    protected String name;

    /** A konstruktorban állítható a név */
    public Name(String name) {
        this.name = name;
    }

    /** Getter */
    public String getName() {
        return this.name;
    }
}
