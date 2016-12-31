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

        Pos p0 = new Pos(ix, iy);
        Pos p1 = new Pos(ix + spa, iy - spa);
        Pos p3 = new Pos(p1.x + spa, p1.y - spa);
        Pos p2 = new Pos(p3.x + spa, p3.y);
        Pos p5 = new Pos(p3.x - spa, p3.y);
        Pos p4 = new Pos(p5.x - spa, p5.y - spa);

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
