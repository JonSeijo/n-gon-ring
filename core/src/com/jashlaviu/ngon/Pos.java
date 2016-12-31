package com.jashlaviu.ngon;

// Clase simple para modelar una posicion entera
public class Pos {
    // These are public for simplicity, but cant be modified (final)
    public final int x;
    public final int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
