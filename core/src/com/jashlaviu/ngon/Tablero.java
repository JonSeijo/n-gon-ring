package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Tablero {

    private int tam, spacing;
    private int initialX, initialY;
    private ArrayList<Pos> positions;
    private ArrayList<Nodo> nodos;

    public Tablero(int tam, int spacing) {
        this.tam = tam;
        this.spacing = spacing;
        this.initialX = 0;
        this.initialY = 0;
        this.nodos = new ArrayList<Nodo>();
        this.fillEmptyPositions();
        this.updatePositions(this.spacing);
        this.agregarNodos();
    }

    private void fillEmptyPositions() {
        this.positions = new ArrayList<Pos>(this.tam * 2);
        for (int i = 0; i < this.tam*2; i++) {
            this.positions.add(i, new Pos(0, 0));
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).render(batch, this.positions.get(i));
        }
    }

    public void updatePositions(int new_spacing) {
        this.spacing = new_spacing;

        int ix = this.initialX;
        int iy = this.initialY;

        int d = this.spacing;
        int h = (int)(Math.sqrt(d*d - d*d/4));
        int d_prima = (int)(Math.sqrt(d*d - h*h));

        // Las coordenadas estan calculadas a mano en mi cuaderno. Pitagoras FTW
        Pos p0 = new Pos(-d/2 + ix, 3*h/2 + iy);
        Pos p1 = new Pos(0 + ix, h/2 + iy);
        Pos p2 = new Pos(3*d/2 + ix, -h/2 + iy);
        Pos p3 = new Pos(d/2 + ix, -h/2 + iy);
        Pos p4 = new Pos(-(d/2 + d_prima) + ix, -3*h/2 + iy);
        Pos p5 = new Pos(-d/2 + ix, -h/2 + iy);

        this.positions.set(0, p0);
        this.positions.set(1, p1);
        this.positions.set(2, p2);
        this.positions.set(3, p3);
        this.positions.set(4, p4);
        this.positions.set(5, p5);
    }

    private void agregarNodos() {
        for (int i = 0; i < this.tam*2; i++) {
            this.nodos.add(new Nodo(i));
        }
    }

    public void dispose() {
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).dispose();
        }
    }

}
