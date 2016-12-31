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
        int spa = this.spacing;
        int d_spa = (int) (this.spacing / 1.4142f); // raiz de 2
        int lambda = (int) (2 * 1.4142f);

        Pos p0 = new Pos(-d_spa*lambda + ix, d_spa*lambda + iy);
        Pos p1 = new Pos(-d_spa + ix, d_spa + iy);

        Pos p2 = new Pos(spa*lambda + ix, 0 + iy);
        Pos p3 = new Pos(spa + ix, 0 + iy);

        Pos p4 = new Pos(-d_spa*lambda + ix, -d_spa*lambda + iy);
        Pos p5 = new Pos(-d_spa + ix, -d_spa + iy);

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
