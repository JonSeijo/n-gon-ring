package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Tablero {

    private int tam;
    private int spacing;
    private int initialX;
    private int initialY;
    private ArrayList<Pos> positions;
    private ArrayList<Nodo> nodos;

    public Tablero(int tam, int spacing) {
        this.tam = tam;
        this.spacing = spacing;
        this.initialX = 0;
        this.initialY = 0;
        this.positions = new ArrayList<Pos>(this.tam * 2);
        this.nodos = new ArrayList<Nodo>();
        this.createTrianglePositions();
    }

    private void createTrianglePositions() {
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

        this.positions.add(0, p0);
        this.positions.add(1, p1);
        this.positions.add(2, p2);
        this.positions.add(3, p3);
        this.positions.add(4, p4);
        this.positions.add(5, p5);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).render(batch, this.positions.get(i));
        }
    }

    public void agregarNodo(Nodo nodo) {
        if (this.nodos.size() >= this.tam*2) {
            System.out.println("NO podes agregar tantos nodos!!");
            return;
        }
        this.nodos.add(nodo);
    }

    public void dispose() {
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).dispose();
        }
    }

}
