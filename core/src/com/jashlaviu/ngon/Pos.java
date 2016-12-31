package com.jashlaviu.ngon;

// Clase simple para modelar una posicion entera
public class Pos {
    // These are public for simplicity, but cant be modified (final)
    public final double x;
    public final double y;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
